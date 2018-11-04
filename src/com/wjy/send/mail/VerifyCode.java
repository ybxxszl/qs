package com.wjy.send.mail;

import com.alibaba.fastjson.JSONObject;
import com.wjy.jedis.RedisUtil;
import com.wjy.send.info.InfoUtil;
import com.wjy.util.HttpClientUtil;
import com.wjy.util.PropertiesUtil;

public class VerifyCode {

	public JSONObject send(String authorEmail) throws Exception {

		String verifyCode = InfoUtil.getVerifyCode();

		RedisUtil.set("verifycode:" + authorEmail, verifyCode,
				Integer.parseInt(PropertiesUtil.getValue("verifycode.mills")));

		JSONObject mqInfo = new JSONObject();
		JSONObject mailInfo = new JSONObject();

		mailInfo.put("recipientAddress", authorEmail);
		mailInfo.put("text", verifyCode);

		mqInfo.put("type", "pc");
		mqInfo.put("name", "Mail_VerifyCode");
		mqInfo.put("mailInfo", mailInfo);
		mqInfo.put("smsInfo", null);

		JSONObject object = HttpClientUtil.doPost(PropertiesUtil.getValue("mq.url"), mqInfo, null);

		return object;

	}

}
