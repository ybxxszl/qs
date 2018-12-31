package com.wjy.test;

import com.wjy.delay.TestDelay;

public class TestMain {

	public static void main(String[] args) {

		try {

			// new TestQueue().test();

			new TestDelay().test();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
