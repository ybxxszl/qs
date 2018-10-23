package com.wjy.test.queue.pc.main;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
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
