package com.wjy.api.swagger;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;

import com.wjy.bean.swagger.SwaggerBean;
import com.wjy.response.ReturnBuilder;
import com.wjy.swagger.SwaggerLOGManage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Swagger")
@Path(value = "/swagger")
@Produces(value = "application/json;charset=utf-8")
public class SwaggerAPI extends SwaggerLOGManage {

	private static final Logger LOGGER = Logger.getLogger(SwaggerAPI.class);

	@ApiOperation(value = "添加")
	@POST
	@Path(value = "/insert")
	public ReturnBuilder insert(SwaggerBean swaggerBean) {

		LOGGER.info(swaggerBean.toString());

		try {
			return ReturnBuilder.successMsg("添加成功");
		} catch (Exception e) {
			return ReturnBuilder.errorException(e);
		}

	}

	@ApiOperation(value = "删除")
	@POST
	@Path(value = "/delete")
	public ReturnBuilder delete(
			@ApiParam(value = "Swagger - ID", example = "1", required = true) @QueryParam(value = "swaggerId") Integer swaggerId) {

		LOGGER.info("swaggerId - " + swaggerId);

		try {
			return ReturnBuilder.successMsg("删除成功");
		} catch (Exception e) {
			return ReturnBuilder.errorException(e);
		}

	}

	@ApiOperation(value = "修改")
	@POST
	@Path(value = "/update")
	public ReturnBuilder update(
			@ApiParam(value = "Swagger - ID", example = "1", required = true) @QueryParam(value = "swaggerId") Integer swaggerId,
			@ApiParam(value = "Swagger - NAME", example = "swagger", required = true) @QueryParam(value = "swaggerName") String swaggerName) {

		LOGGER.info("swaggerId - " + swaggerId + " swaggerName - " + swaggerName);

		try {
			return ReturnBuilder.successMsg("修改成功");
		} catch (Exception e) {
			return ReturnBuilder.errorException(e);
		}

	}

	@ApiOperation(value = "查询")
	@GET
	@Path(value = "/select")
	public ReturnBuilder select(
			@ApiParam(value = "Swagger - ID", example = "1", required = true) @QueryParam(value = "swaggerId") Integer swaggerId) {

		LOGGER.info("swaggerId - " + swaggerId);

		try {
			return ReturnBuilder.successMsg("修改成功");
		} catch (Exception e) {
			return ReturnBuilder.errorException(e);
		}

	}

}
