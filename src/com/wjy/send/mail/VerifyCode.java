package com.wjy.send.mail;

import com.alibaba.fastjson.JSONObject;
import com.wjy.jedis.RedisUtil;
import com.wjy.util.RandomCodeUtil;
import com.wjy.util.HttpClientUtil;
import com.wjy.util.PropertiesUtil;

public class VerifyCode {

	private static String mqUrl;
	private static String mqVerifyCodeMills;

	static {

		mqUrl = PropertiesUtil.getValue("mq.url");
		mqVerifyCodeMills = PropertiesUtil.getValue("mq.verifycode.mills");

	}

	public JSONObject send(String authorEmail) throws Exception {

		String verifyCode = RandomCodeUtil.getVerifyCode();

		RedisUtil.set("verifycode:" + authorEmail, verifyCode, Integer.parseInt(mqVerifyCodeMills));

		JSONObject mqInfo = new JSONObject();
		JSONObject mailInfo = new JSONObject();

		mailInfo.put("recipientAddress", authorEmail);
		mailInfo.put("text", verifyCode);

		mqInfo.put("type", "pc");
		mqInfo.put("name", "Mail_VerifyCode");
		mqInfo.put("mailInfo", mailInfo);
		mqInfo.put("smsInfo", null);

		JSONObject object = HttpClientUtil.doPost(mqUrl + "/postVerifyCode", mqInfo, null);

		return object;

	}

}
