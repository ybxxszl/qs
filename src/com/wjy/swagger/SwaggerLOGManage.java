package com.wjy.swagger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wjy.log.LOGManage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "default")
@ApiResponses(value = { @ApiResponse(code = 400, message = "no auth"),
		@ApiResponse(code = 500, message = "has error", response = ErrorBean.class) })
public abstract class SwaggerLOGManage extends LOGManage {

	protected static Logger LOGGER = null;

	public SwaggerLOGManage() {

		super();

		LOGGER = LogManager.getLogger(this.getClass());

	}

}
