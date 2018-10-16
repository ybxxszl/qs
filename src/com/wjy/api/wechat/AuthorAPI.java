package com.wjy.api.wechat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.wjy.log.LOG;

@Path(value = "/author")
@Produces(value = "application/json;charset=utf-8")
public class AuthorAPI {

	@GET
	@Path(value = "/getAuthor")
	public Response getAuthor(@QueryParam(value = "code") String code) throws Exception {

		LOG.pInfo("code: " + code);

		return null;

	}

}
