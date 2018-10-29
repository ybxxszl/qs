package com.wjy.dao.wechat;

import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.wjy.exception.business.BusinessException;
import com.wjy.exception.system.SystemException;
import com.wjy.jdbc.SQLUtil;
import com.wjy.thread.ThreadLocalEnv;
import com.wjy.thread.ThreadLocalVar;
import com.wjy.util.DateUtil;
import com.wjy.util.HttpRequestUtil;
import com.wjy.util.PropertiesUtil;
import com.wjy.util.WeChatUtil;
import com.wjy.vo.Author;

public class AuthorDao extends SQLUtil {

	private static final Logger LOGGER = Logger.getLogger(AuthorDao.class);

	private static String tokenUrl;
	private static String tokenMills;

	static {

		tokenUrl = PropertiesUtil.getValue("token.url");
		tokenMills = PropertiesUtil.getValue("token.mills");

	}

	public JSONObject getAuthor(String code) throws Exception {

		JSONObject jsonObject1 = new JSONObject();

		JSONObject jsonObject2 = new JSONObject();

		JSONObject os = WeChatUtil.getCode2Session(code);

		LOGGER.info("code2Session：" + os.toString());

		if (os.containsKey("session_key")) {

			jsonObject1.put("session_key", os.getString("session_key"));

			String sql = "SELECT author.author_id, author.author_account, author.author_password, author.author_name, author.author_sex, "
					+ "author.author_birthday, author.author_phone, author.author_email, author.author_photo, author.author_state, author.open_id "
					+ "FROM author WHERE author.open_id = ?";

			Object[] objects = new Object[] { os.getString("openid") };

			List<Author> authorList = Query(sql, objects, Author.class);

			if (authorList.size() == 1) {

				Author author = authorList.get(0);

				String authorId = author.getAuthor_id();
				int authorState = author.getAuthor_state();

				if (authorState == 0) {

					throw new BusinessException("您为未激活状态！！！");

				}

				jsonObject2.put("authorId", author.getAuthor_id());
				jsonObject2.put("authorAccount", author.getAuthor_account());
				jsonObject2.put("authorName", author.getAuthor_name());
				jsonObject2.put("authorSex", author.getAuthor_sex());
				jsonObject2.put("authorBirthday", DateUtil.getFormatDate(author.getAuthor_birthday()));
				jsonObject2.put("authorPhone", author.getAuthor_phone());
				jsonObject2.put("authorEmail", author.getAuthor_email());
				jsonObject2.put("authorPhoto", author.getAuthor_photo());

				String param = "authorId=" + authorId + "&mills=" + tokenMills;

				JSONObject t = HttpRequestUtil.sendGet(tokenUrl, param);

				LOGGER.info("token：" + t.toString());

				if (t.getInteger("status") == 200) {

					String token = t.getString("data");

					jsonObject1.put("token", token);

					ThreadLocalVar threadLocalVar = ThreadLocalEnv.getENV();

					threadLocalVar.setAuthor_id(authorId);
					threadLocalVar.setToken(token);

					ThreadLocalEnv.setENV(threadLocalVar);

				} else {

					throw new SystemException("获取token失败！！！");

				}

			}

			jsonObject1.put("author", jsonObject2);

		} else {

			throw new SystemException(os.getString("errMsg"));

		}

		return jsonObject1;

	}

}
