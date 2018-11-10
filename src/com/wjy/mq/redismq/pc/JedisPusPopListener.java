package com.wjy.mq.redismq.pc;

public class JedisPusPopListener {

	public static void main(String[] args) {

		while (true) {

			String message = Poper.pop(0, "TestQueue");

			System.out.println(message);

		}

	}

}
