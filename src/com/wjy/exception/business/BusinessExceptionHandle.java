package com.wjy.exception.business;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.apache.log4j.Logger;

import com.wjy.exception.business.BusinessException;
import com.wjy.response.ResponseBuilder;

/**
 * @date 2018年10月10日
 * @author ybxxszl
 * @description 业务异常处理
 */
public class BusinessExceptionHandle implements ExceptionMapper<BusinessException> {

	private static final Logger LOGGER = Logger.getLogger(BusinessExceptionHandle.class);

	@Override
	public Response toResponse(BusinessException exception) {

		LOGGER.info("业务异常：" + exception.getMessage());

		return ResponseBuilder.exception(exception);

	}

}
