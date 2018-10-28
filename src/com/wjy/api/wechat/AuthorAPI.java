package com.wjy.api.wechat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.wjy.dao.wechat.AuthorDao;
import com.wjy.response.ResponseBuilder;

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

}
