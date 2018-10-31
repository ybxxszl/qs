package com.wjy.api.wechat;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.wjy.dao.wechat.AuthorDao;
import com.wjy.response.ResponseBuilder;
import com.wjy.util.HttpClientUtil;
import com.wjy.util.PropertiesUtil;

@Path(value = "/wechat/author")
@Produces(value = "application/json;charset=utf-8")
public class AuthorAPI {

	private static final Logger LOGGER = Logger.getLogger(AuthorAPI.class);

	private AuthorDao authorDao = new AuthorDao();

	@GET
	@Path(value = "/getAuthor")
	public Response getAuthor(@QueryParam(value = "code") String code) throws Exception {

		LOGGER.info("code: " + code);

		return ResponseBuilder.success(authorDao.getAuthor(code));

	}

	@PUT
	@Path(value = "/sendVerifyCode")
	public Response sendVerifyCode(@QueryParam(value = "authorEmail") String authorEmail) throws Exception {

		LOGGER.info("authorEmail: " + authorEmail);

		JSONObject mqInfo = new JSONObject();
		JSONObject mailInfo = new JSONObject();

		mailInfo.put("recipientAddress", "1062837400@qq.com");
		mailInfo.put("text", "123456");

		mqInfo.put("type", "pc");
		mqInfo.put("name", "Mail_VerifyCode");
		mqInfo.put("mailInfo", mailInfo);
		mqInfo.put("smsInfo", null);

		HttpClientUtil.doPost(PropertiesUtil.getValue("mq.url"), mqInfo, null);

		return null;

	}

}
