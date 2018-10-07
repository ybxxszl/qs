package com.wjy.restful;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.wjy.exception.BusinessException;
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

		String exception_message = ReturnMessage.ERROR_500;

		if (e instanceof NullPointerException) {

			exception_message = ReturnMessage.ERROR_501;

		} else if (e instanceof IndexOutOfBoundsException) {

			exception_message = ReturnMessage.ERROR_502;

		} else if (e instanceof IllegalAccessException) {

			exception_message = ReturnMessage.ERROR_503;

		} else if (e instanceof ArrayIndexOutOfBoundsException) {

			exception_message = ReturnMessage.ERROR_504;

		} else if (e instanceof ClassNotFoundException) {

			exception_message = ReturnMessage.ERROR_505;

		} else if (e instanceof SQLException) {

			if ("数据库连接获取失败！".equals(e.getMessage())) {

				exception_message = ReturnMessage.ERROR_511;

			} else {

				exception_message = ReturnMessage.ERROR_512;

			}

		} else if (e instanceof BusinessException) {

			exception_message = e.getMessage();

		}

		return error(exception_message);

	}

}
