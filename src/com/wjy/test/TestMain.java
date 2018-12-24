package com.wjy.test;

import com.wjy.queue.TestQueue;

public class TestMain {

	public static void main(String[] args) {

		try {

			new TestQueue().test();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
