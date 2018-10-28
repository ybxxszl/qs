package com.wjy.util;

import com.alibaba.fastjson.JSONObject;

/**
 * @date 2018年10月16日
 * @author ybxxszl
 * @description 微信工具类
 */
public class WeChatUtil {

	private static String appId;
	private static String appSecret;
	private static String code2SessionParam;
	private static String code2SessionUrl;

	static {

		appId = PropertiesUtil.getValue("wechat.appId");
		appSecret = PropertiesUtil.getValue("wechat.appSecret");
		code2SessionParam = PropertiesUtil.getValue("wechat.code2Session.param");
		code2SessionUrl = PropertiesUtil.getValue("wechat.code2Session.url");

	}

	/**
	 * @date 2018年10月28日
	 * @author ybxxszl
	 * @description 使用code获取openid和session_key
	 * @param code
	 *            临时登录凭证code
	 * @return
	 * @return JSONObject
	 */
	public static JSONObject getCode2Session(String code) {

		String param = code2SessionParam.replace("APPID", appId).replace("SECRET", appSecret).replace("JSCODE", code);

		JSONObject jsonObject = HttpRequestUtil.sendGet(code2SessionUrl, param);

		return jsonObject;

	}

}
