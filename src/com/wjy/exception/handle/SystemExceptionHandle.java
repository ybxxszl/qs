package com.wjy.exception.handle;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.wjy.exception.SystemException;
import com.wjy.response.ResponseBuilder;

public class SystemExceptionHandle implements ExceptionMapper<SystemException> {

	@Override
	public Response toResponse(SystemException exception) {

		return ResponseBuilder.exception(exception);

	}

}
