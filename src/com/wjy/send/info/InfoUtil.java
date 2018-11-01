package com.wjy.send.info;

public class InfoUtil {

	public static String getVerifyCode() {

		return (int) ((Math.random() * 9 + 1) * 100000) + "";

	}

}
