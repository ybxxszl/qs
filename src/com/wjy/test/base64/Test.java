package com.wjy.test.base64;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Test {

	public static void main(String[] args) {

		encoder();

		decoder();

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

}
