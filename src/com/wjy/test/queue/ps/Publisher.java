package com.wjy.test.queue.ps;

import redis.clients.jedis.Jedis;

public class Publisher {

	public void publish(final Jedis jedis) {

		new Thread(new Runnable() {

			@Override
			public void run() {

				try {

					Thread.sleep(1000);

				} catch (InterruptedException e) {

					e.printStackTrace();

				}

				System.out.println("发布消息");

				for (int i = 1; i <= 10; i++) {

					jedis.publish("TestQueue", "Hello" + i);

				}

			}

		}).start();

	}

}
