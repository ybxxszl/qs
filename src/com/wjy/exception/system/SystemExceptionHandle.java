package com.wjy.exception.system;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.apache.log4j.Logger;

import com.wjy.response.ResponseBuilder;

/**
 * @date 2018年10月29日
 * @author ybxxszl
 * @description 系统异常处理
 */
public class SystemExceptionHandle implements ExceptionMapper<SystemException> {

	private static final Logger LOGGER = Logger.getLogger(SystemExceptionHandle.class);

	@Override
	public Response toResponse(SystemException exception) {

		LOGGER.info("系统异常：" + exception.getMessage());

		return ResponseBuilder.exception(exception);

	}

}
