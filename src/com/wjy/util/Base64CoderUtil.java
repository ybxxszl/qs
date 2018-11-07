package com.wjy.util;

import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

public class Base64CoderUtil {

	public static String encode(String str) {

		char[] c = Base64Coder.encode(str.getBytes());

		return new String(c);

	}

	public static String decode(String str) {

		byte[] b = Base64Coder.decode(str);

		return new String(b);

	}

}
