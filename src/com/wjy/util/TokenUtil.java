package com.wjy.util;

import java.io.IOException;
import java.util.UUID;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

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

	public static void encoder() {

		BASE64Encoder encoder = new BASE64Encoder();

		String str = encoder.encodeBuffer("wjy".getBytes());

		System.out.println(str);

	}

	public static void decoder() {

		BASE64Decoder decoder = new BASE64Decoder();

		String str = null;

		try {

			str = new String(decoder.decodeBuffer("d2p5"));

		} catch (IOException e) {

			System.out.println("IO异常");

			e.printStackTrace();

		}

		System.out.println(str);

	}

	// https://www.cnblogs.com/xiekeli/p/5607107.html
	// https://ninghao.net/course/5509
	public static void main(String[] args) {

		encoder();

		decoder();

	}

}
