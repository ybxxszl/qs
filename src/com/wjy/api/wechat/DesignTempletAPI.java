package com.wjy.api.wechat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.wjy.bean.custom.QueryBean;
import com.wjy.dao.wechat.DesignTempletDao;
import com.wjy.response.ResponseBuilder;

@Path(value = "/wechat/designTemplet")
@Produces(value = "application/json;charset=utf-8")
public class DesignTempletAPI {

	private static final Logger LOGGER = Logger.getLogger(DesignTempletAPI.class);

	DesignTempletDao designTempletDao = new DesignTempletDao();

	@GET
	@Path(value = "/getDesignTempletList")
	public Response getDesignTempletList(@QueryParam(value = "pageCurrent") Integer pageCurrent,
			@QueryParam(value = "pageSize") Integer pageSize, @QueryParam(value = "searchContent") String searchContent)
			throws Exception {

		QueryBean queryBean = new QueryBean();

		queryBean.setPageCurrent(pageCurrent);
		queryBean.setPageSize(pageSize);
		queryBean.setSearchContent(searchContent);

		LOGGER.info(queryBean.toString());

		return ResponseBuilder.success(designTempletDao.getDesignTempletList(designTempletDao.getAuthor(), queryBean));

	}

}
