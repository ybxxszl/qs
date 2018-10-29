package com.wjy.response;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

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
	 * @description exception
	 * @param e
	 * @return Response
	 */
	public static Response exception(Exception e) {

		return error(e.getMessage());

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

}
