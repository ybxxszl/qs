package com.wjy.api.wechat;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.wjy.dao.wechat.DesignTempletDao;
import com.wjy.vo.DesignTemplet;

@Path(value = "/wechat/designTemplet")
@Produces(value = "application/json;charset=utf-8")
public class DesignTempletAPI {

	private static final Logger LOGGER = Logger.getLogger(DesignTempletAPI.class);

	DesignTempletDao designTempletDao = new DesignTempletDao();

	@GET
	@Path(value = "/getDesignTempletList")
	public List<DesignTemplet> getDesignTempletList() throws Exception {

		return designTempletDao.getDesignTempletList(designTempletDao.getAuthor());

	}

}
