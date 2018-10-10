package com.wjy.util;

import java.util.UUID;

/**
 * @date 2018年10月10日
 * @author ybxxszl
 * @description Token工具类
 */
public class TokenUtil {

	/**
	 * @date 2018年10月10日
	 * @author ybxxszl
	 * @description 获取Token，随机的64位字符串
	 * @return String
	 */
	public static String getToken() {

		return UUID.randomUUID().toString() + UUID.randomUUID().toString();

	}

}
