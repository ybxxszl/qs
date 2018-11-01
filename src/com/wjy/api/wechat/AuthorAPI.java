package com.wjy.api.wechat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.wjy.dao.wechat.AuthorDao;
import com.wjy.response.ResponseBuilder;
import com.wjy.send.mail.VerifyCode;

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

	@GET
	@Path(value = "/sendVerifyCode")
	public Response sendVerifyCode(@QueryParam(value = "authorEmail") String authorEmail) throws Exception {

		LOGGER.info("authorEmail: " + authorEmail);

		VerifyCode verifyCode = new VerifyCode();

		JSONObject object = verifyCode.send(authorEmail);

		String msg;

		if (object.getInteger("code") == 200) {
			msg = "验证码发送成功";
		} else {
			msg = "验证码发送失败";
		}

		return ResponseBuilder.success(msg);

	}

}
