package com.wjy.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.wjy.dao.DesignTempletDao;
import com.wjy.log.LOG;
import com.wjy.response.ResponseBuilder;

@Path(value = "/designTemplet")
@Produces(value = "application/json;charset=utf-8")
public class DesignTempletAPI {

	private static final Logger LOGGER = Logger.getLogger(DesignTempletAPI.class);

	private DesignTempletDao designTempletDao = new DesignTempletDao();

	@GET
	@Path(value = "/getDesignTemplet")
	public Response getDesignTemplet(@QueryParam(value = "designTempletId") String designTempletId) throws Exception {

		LOGGER.info("designTempletId: " + designTempletId);

		LOG.pInfo("designTempletId: " + designTempletId);

		return ResponseBuilder.success(designTempletDao.getDesignTemplet(designTempletId));

	}

}
