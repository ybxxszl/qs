package com.wjy.util;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.wjy.util.JSONUtil;

public class ResponseUtil {

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

		return error(e.getMessage());

	}

}
