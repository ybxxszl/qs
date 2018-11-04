package com.wjy.response;

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
	 * @param object
	 * @return Response
	 */
	public static Response exception(Object object) {

		return response(object, 300);

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

		String str = JSONUtil.objectToJson(object);
		return Response.status(code).entity(str).build();

	}

}
