package com.wjy.dao.wechat;

import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.wjy.bean.offical.UserInfo;
import com.wjy.exception.business.BusinessException;
import com.wjy.exception.system.SystemException;
import com.wjy.jdbc.SQLUtil;
import com.wjy.thread.ThreadLocalEnv;
import com.wjy.thread.ThreadLocalVar;
import com.wjy.util.HttpRequestUtil;
import com.wjy.util.PropertiesUtil;
import com.wjy.util.RandomCodeUtil;
import com.wjy.util.WeChatUtil;
import com.wjy.vo.Author;
import com.wjy.vo.WXAuthor;

public class AuthorDao extends SQLUtil {

	private static final Logger LOGGER = Logger.getLogger(AuthorDao.class);

	private static String tokenUrl;
	private static String tokenMills;

	static {

		tokenUrl = PropertiesUtil.getValue("token.url");
		tokenMills = PropertiesUtil.getValue("token.mills");

	}

	public JSONObject loginAuthor(String code) throws Exception {

		JSONObject jsonObject1 = new JSONObject();

		JSONObject jsonObject2 = new JSONObject();

		JSONObject os = WeChatUtil.getCode2Session(code);

		LOGGER.info("code2Session：" + os.toString());

		if (os.containsKey("session_key")) {

			jsonObject1.put("sessionKey", os.getString("session_key"));

			String sql = "SELECT wx_author.wx_author_id, wx_author.wx_author_email, wx_author.wx_author_nick_name, "
					+ "wx_author.wx_author_sex, wx_author.wx_author_country, wx_author.wx_author_province, wx_author.wx_author_city, "
					+ "wx_author.wx_author_avatar_url, wx_author.wx_author_open_id FROM wx_author WHERE wx_author.wx_author_open_id = ?";

			Object[] objects = new Object[] { os.getString("openid") };

			List<WXAuthor> wxAuthorList = Query(sql, objects, WXAuthor.class);

			if (wxAuthorList.size() == 1) {

				WXAuthor wxAuthor = wxAuthorList.get(0);

				String wxAuthorId = wxAuthor.getWx_author_id();

				jsonObject2.put("wxAuthorEmail", wxAuthor.getWx_author_email());
				jsonObject2.put("wxAuthorNickName", wxAuthor.getWx_author_nick_name());
				jsonObject2.put("wxAuthorSex", wxAuthor.getWx_author_sex());
				jsonObject2.put("wxAuthorCountry", wxAuthor.getWx_author_country());
				jsonObject2.put("wxAuthorProvince", wxAuthor.getWx_author_province());
				jsonObject2.put("wxAuthorCity", wxAuthor.getWx_author_city());
				jsonObject2.put("wxAuthorAvatarUrl", wxAuthor.getWx_author_avatar_url());

				String param = "wxAuthorId=" + wxAuthorId + "&mills=" + tokenMills;

				JSONObject object = HttpRequestUtil.sendGet(tokenUrl, param);

				if (object.getInteger("status") == 200) {

					String token = object.getString("data");

					LOGGER.info("token：" + token);

					jsonObject1.put("token", token);

					ThreadLocalVar threadLocalVar = ThreadLocalEnv.getENV();

					threadLocalVar.setAuthor_id(wxAuthorId);
					threadLocalVar.setToken(token);

					ThreadLocalEnv.setENV(threadLocalVar);

				} else {
					throw new SystemException("获取token失败！！！");
				}

			}

			jsonObject1.put("wxAuthor", jsonObject2);

		} else {
			throw new SystemException(os.getString("errMsg"));
		}

		return jsonObject1;

	}

	public boolean verifyEmail(String authorEmail) throws Exception {

		String sql = "SELECT wx_author.* FROM wx_author WHERE wx_author.wx_author_email = ?";

		Object[] objects = new Object[] { authorEmail };

		List<Author> authorList = Query(sql, objects, Author.class);

		if (authorList.size() == 0) {
			return true;
		} else {
			return false;
		}

	}

	public String registerAuthor(String authorEmail, UserInfo userInfo) throws Exception {

		String sex = "未知";

		if (userInfo.getGender() == 1) {
			sex = "男";
		}
		if (userInfo.getGender() == 2) {
			sex = "女";
		}

		String sql = "INSERT INTO wx_author(wx_author.wx_author_id, wx_author.wx_author_email, wx_author.wx_author_nick_name, "
				+ "wx_author.wx_author_sex, wx_author.wx_author_country, wx_author.wx_author_province, wx_author.wx_author_city, "
				+ "wx_author.wx_author_avatar_url, wx_author.wx_author_open_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		int num = Update(sql, RandomCodeUtil.getUUID(), authorEmail, userInfo.getNickName(), sex, userInfo.getCountry(),
				userInfo.getCity(), userInfo.getProvince(), userInfo.getAvatarUrl(), userInfo.getOpenId());

		if (num == 0) {
			throw new BusinessException("注册失败，请重新注册");
		}

		return "注册成功";

	}

}
