package com.wjy.util;

import java.util.UUID;

/**
 * @date 2018年10月9日
 * @author ybxxszl
 * @description RandomCode工具类
 */
public class RandomCodeUtil {

	/**
	 * @date 2018年10月9日
	 * @author ybxxszl
	 * @description 获取UUID
	 * @return String 随机的32位字符串
	 */
	public static String getUUID() {

		return UUID.randomUUID().toString();

	}

	/**
	 * @date 2018年11月11日
	 * @author ybxxszl
	 * @description 获取验证码
	 * @return String 随机的6位字符串
	 */
	public static String getVerifyCode() {

		return (int) ((Math.random() * 9 + 1) * 100000) + "";

	}

}
