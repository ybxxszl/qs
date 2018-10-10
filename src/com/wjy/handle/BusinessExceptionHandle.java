package com.wjy.handle;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.apache.log4j.Logger;

import com.wjy.exception.BusinessException;
import com.wjy.response.ResponseBuilder;

public class BusinessExceptionHandle implements ExceptionMapper<BusinessException> {

	private static final Logger LOGGER = Logger.getLogger(BusinessExceptionHandle.class);

	@Override
	public Response toResponse(BusinessException exception) {

		LOGGER.warn("业务异常：" + exception.getMessage());

		return ResponseBuilder.exception(exception);

	}

}
