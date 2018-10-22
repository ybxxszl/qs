package com.wjy.mq;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (true) {

			String message = scanner.nextLine();

			if ("exit".equals(message)) {

				break;

			} else {

				Pusher.push("TestQueue", message);

			}

		}

	}

}
