package com.wjy.util;

import java.util.UUID;

public class TokenUtil {

	public static String getToken() {

		return UUID.randomUUID().toString() + UUID.randomUUID().toString();

	}

}
