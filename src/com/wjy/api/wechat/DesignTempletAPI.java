package com.wjy.api.wechat;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

@Path(value = "/wechat/designTemplet")
@Produces(value = "application/json;charset=utf-8")
public class DesignTempletAPI {

	private static final Logger LOGGER = Logger.getLogger(DesignTempletAPI.class);

}
