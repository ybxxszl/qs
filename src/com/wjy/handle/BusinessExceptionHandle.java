package com.wjy.handle;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.wjy.exception.BusinessException;
import com.wjy.response.ResponseBuilder;

public class BusinessExceptionHandle implements ExceptionMapper<BusinessException> {

	@Override
	public Response toResponse(BusinessException exception) {

		return ResponseBuilder.exception(exception);

	}

}
