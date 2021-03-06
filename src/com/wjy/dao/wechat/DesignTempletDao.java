package com.wjy.dao.wechat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wjy.bean.custom.QueryBean;
import com.wjy.exception.business.BusinessException;
import com.wjy.jdbc.SQLUtil;
import com.wjy.thread.ThreadLocalEnv;
import com.wjy.vo.Author;
import com.wjy.vo.DesignTemplet;
import com.wjy.vo.WXAuthor;

public class DesignTempletDao extends SQLUtil {

	private static final Logger LOGGER = Logger.getLogger(DesignTempletDao.class);

	public Author getAuthor() throws Exception {

		String sql1 = "SELECT wx_author.wx_author_id, wx_author.wx_author_email, wx_author.wx_author_nick_name, "
				+ "wx_author.wx_author_sex, wx_author.wx_author_country, wx_author.wx_author_province, wx_author.wx_author_city, "
				+ "wx_author.wx_author_avatar_url, wx_author.wx_author_open_id FROM wx_author WHERE wx_author.wx_author_id = ?";

		Object[] objects1 = new Object[] { ThreadLocalEnv.getENV().getAuthor_id() };

		List<WXAuthor> wxAuthorList = Query(sql1, objects1, WXAuthor.class);

		if (wxAuthorList.size() == 0) {
			throw new BusinessException("对不起，没有查询到信息");
		}

		WXAuthor wxAuthor = wxAuthorList.get(0);

		LOGGER.info(wxAuthor.toString());

		String sql2 = "SELECT author.author_id, author.author_account, author.author_password, author.author_name, author.author_sex, "
				+ "author.author_birthday, author.author_phone, author.author_email, author.author_photo, author.author_state "
				+ "FROM author WHERE author.author_email = ?";

		Object[] objects2 = new Object[] { wxAuthor.getWx_author_email() };

		List<Author> authorList = Query(sql2, objects2, Author.class);

		if (authorList.size() == 0) {
			throw new BusinessException("对不起，没有查询到信息");
		}

		Author author = authorList.get(0);

		LOGGER.info(author.toString());

		return author;

	}

	public JSONArray getDesignTempletList(Author author, QueryBean queryBean) throws Exception {

		String searchContent = queryBean.getSearchContent();

		String like = "";

		if (!"".equals(searchContent)) {
			like = "AND design_templet.design_templet_name LIKE '%" + searchContent + "%' ";
		}

		String sql = "SELECT design_templet.design_templet_id, design_templet.design_templet_name, "
				+ "design_templet.finish_time, design_templet.start_recovery_time, design_templet.end_recovery_time, "
				+ "design_templet.state, design_templet.link, design_templet.author_id "
				+ "FROM design_templet WHERE design_templet.author_id = ? " + like + "LIMIT "
				+ queryBean.getCalculateItemBegin() + ", " + queryBean.getPageSize();

		Object[] objects = new Object[] { author.getAuthor_id() };

		List<DesignTemplet> designTempletList = Query(sql, objects, DesignTemplet.class);

		if (designTempletList.size() == 0) {
			throw new BusinessException("尚未创建调查问卷，请在网站创建");
		}

		LOGGER.info(designTempletList.toString());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		JSONArray array = new JSONArray();
		JSONObject object = null;

		for (DesignTemplet designTemplet : designTempletList) {

			object = new JSONObject();

			object.put("designTempletId", designTemplet.getDesign_templet_id());
			object.put("designTempletName", designTemplet.getDesign_templet_name());
			object.put("finishTime", sdf.format(designTemplet.getFinish_time()));

			Date startRecoveryTime = designTemplet.getStart_recovery_time();
			Date endRecoveryTime = designTemplet.getEnd_recovery_time();

			if (startRecoveryTime == null) {
				object.put("startRecoveryTime", "尚未开始回收");
			} else {
				object.put("startRecoveryTime", sdf.format(startRecoveryTime));
			}
			if (endRecoveryTime == null) {
				object.put("endRecoveryTime", "尚未结束回收");
			} else {
				object.put("endRecoveryTime", sdf.format(endRecoveryTime));
			}

			object.put("state", designTemplet.getState());

			array.add(object);

		}

		return array;

	}

}
