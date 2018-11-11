package com.wjy.util;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.wjy.exception.system.SystemException;

public class TokenUtil {

	public static String getToken(String wxAuthorId) throws Exception {

		String token = null;

		String url = PropertiesUtil.getValue("token.url") + "/getToken";
		String param = "wxAuthorId=" + wxAuthorId + "&mills=" + PropertiesUtil.getValue("token.mills");

		JSONObject object = HttpRequestUtil.sendGet(url, param);

		if (object.getInteger("status") == 200) {
			token = object.getString("data");
		} else {
			throw new SystemException("获取token失败！！！");
		}

		return token;

	}

	public static boolean verifyToken(String token) {

		String url = PropertiesUtil.getValue("token.url") + "/verifyToken";
		String param = "token=" + token + "&returnValue=true";

		try {

			JSONObject object = HttpRequestUtil.sendGet(url, param);

			object.getObject("data", new TypeReference<Map<String, Object>>() {
			});

			return true;

		} catch (Exception e) {

			return false;

		}

	}

}
