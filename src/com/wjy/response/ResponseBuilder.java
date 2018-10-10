package com.wjy.response;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.wjy.exception.BusinessException;
import com.wjy.message.SystemExceptionMessage;
import com.wjy.util.JSONUtil;

public class ResponseBuilder {

	public static Response success(Object msg) {
		return response(msg, 200);
	}

	public static Response error(Object msg) {
		return response(msg, 500);
	}

	public static Response response(Object msg, int code) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", msg);
		String str = JSONUtil.objectToJson(map);
		return Response.status(code).entity(str).build();

	}

	public static Response exception(Exception e) {

		String message;

		if (e instanceof NullPointerException) {

			message = SystemExceptionMessage.ERROR_101;

		} else if (e instanceof IndexOutOfBoundsException) {

			message = SystemExceptionMessage.ERROR_102;

		} else if (e instanceof IllegalAccessException) {

			message = SystemExceptionMessage.ERROR_103;

		} else if (e instanceof ArrayIndexOutOfBoundsException) {

			message = SystemExceptionMessage.ERROR_104;

		} else if (e instanceof ClassNotFoundException) {

			message = SystemExceptionMessage.ERROR_105;

		} else if (e instanceof SQLException) {

			message = SystemExceptionMessage.ERROR_106;

		} else if (e instanceof BusinessException) {

			message = e.getMessage();

		} else {

			message = SystemExceptionMessage.ERROR_100;

		}

		return error(message);

	}

}
