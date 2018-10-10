package com.wjy.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.wjy.dao.DesignTempletDao;
import com.wjy.response.ResponseBuilder;

@Path(value = "/designTemplet")
@Produces(value = "application/json;charset=utf-8")
public class DesignTempletAPI {

	private DesignTempletDao designTempletDao = new DesignTempletDao();

	@GET
	@Path(value = "/getDesignTemplet")
	public Response getDesignTemplet(@QueryParam(value = "designTempletId") String designTempletId) throws Exception {

		System.out.println(("designTempletId:" + designTempletId));

		return ResponseBuilder.success(designTempletDao.getDesignTemplet(designTempletId));

	}

}
