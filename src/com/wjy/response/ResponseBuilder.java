package com.wjy.response;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.wjy.exception.BusinessException;
import com.wjy.exception.SystemExceptionMessage;
import com.wjy.util.JSONUtil;

/**
 * @date 2018年10月10日
 * @author ybxxszl
 * @description 建立响应
 */
public class ResponseBuilder {

	/**
	 * @date 2018年10月10日
	 * @author ybxxszl
	 * @description success
	 * @param object
	 * @return Response
	 */
	public static Response success(Object object) {
		return response(object, 200);
	}

	/**
	 * @date 2018年10月10日
	 * @author ybxxszl
	 * @description error
	 * @param object
	 * @return Response
	 */
	public static Response error(Object object) {
		return response(object, 500);
	}

	/**
	 * @date 2018年10月10日
	 * @author ybxxszl
	 * @description response
	 * @param object
	 * @param code
	 * @return Response
	 */
	public static Response response(Object object, int code) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", object);
		String str = JSONUtil.objectToJson(map);
		return Response.status(code).entity(str).build();

	}

	/**
	 * @date 2018年10月10日
	 * @author ybxxszl
	 * @description exception
	 * @param e
	 * @return Response
	 */
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
