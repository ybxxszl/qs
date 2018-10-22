package com.wjy.test.queue.pc;

import redis.clients.jedis.Jedis;

public class Pusher {

	public void push(final Jedis jedis) {

		new Thread(new Runnable() {

			@Override
			public void run() {

				try {

					Thread.sleep(1000);

				} catch (InterruptedException e) {

					e.printStackTrace();

				}

				System.out.println("生产消息");

				for (int i = 1; i <= 10; i++) {

					jedis.lpush("TestQueue", "Hello" + i);

				}

			}

		}).start();

	}

}
