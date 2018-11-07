package com.wjy.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class BASE64EncoderDecoderUtil {

	public static String encoder(String str) {

		BASE64Encoder encoder = new BASE64Encoder();

		String s = encoder.encodeBuffer(str.getBytes());

		return s;

	}

	public static String decoder(String str) {

		BASE64Decoder decoder = new BASE64Decoder();

		String s = null;

		try {

			s = new String(decoder.decodeBuffer(str));

		} catch (Exception e) {

			e.printStackTrace();

		}

		return s;

	}

}
