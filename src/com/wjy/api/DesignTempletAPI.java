package com.wjy.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.wjy.dao.DesignTempletDao;
import com.wjy.log.LOG;
import com.wjy.restful.ResponseBuilder;
import com.wjy.vo.DesignTemplet;

@Path(value = "/designTemplet")
@Produces(value = "application/json;charset=utf-8")
public class DesignTempletAPI {

	private static final Logger LOGGER = Logger.getLogger(DesignTempletAPI.class);

	private DesignTempletDao designTempletDao = new DesignTempletDao();

	@GET
	@Path(value = "/getDesignTemplet")
	public Response getDesignTemplet(@QueryParam(value = "designTempletId") String designTempletId) {

		DesignTemplet designTemplet = new DesignTemplet(designTempletId, "c5337055-7ae7-4227-b4f7-d65e94b45575");

		LOGGER.info(designTemplet);

		LOG.pInfo(designTemplet);

		try {

			return ResponseBuilder.success(designTempletDao.getDesignTemplet(designTemplet));

		} catch (Exception e) {

			LOGGER.error(e);

			LOG.pError(e.getMessage());
			LOG.pException(e);

			return ResponseBuilder.exception(e);

		}

	}

}
