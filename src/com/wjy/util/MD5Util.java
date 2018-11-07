package com.wjy.util;

import java.security.MessageDigest;

public class MD5Util {

	// MD5加密
	public static String MD5(String str) {

		MessageDigest md5 = null;

		try {

			md5 = MessageDigest.getInstance("MD5");

		} catch (Exception e) {

			e.printStackTrace();

		}

		byte[] b = md5.digest(str.getBytes());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < b.length; i++) {

			int value = ((int) b[i]) & 0xff;

			if (value < 16) {

				sb.append("0");

			}

			sb.append(Integer.toHexString(value));

		}

		return sb.toString();

	}

	// 加密与解密
	public static String JMJM(String str) {

		char[] c = str.toCharArray();

		for (int i = 0; i < c.length; i++) {

			c[i] = (char) (c[i] ^ 'w');
		}

		return new String(c);

	}

}
