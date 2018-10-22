package com.wjy.test.queue.ps;

import redis.clients.jedis.Jedis;

public class Subscriber {

	public void subscrib(final Jedis jedis, final JedisPubSubListener listener) {

		new Thread(new Runnable() {

			@Override
			public void run() {

				try {

					Thread.sleep(1000);

				} catch (InterruptedException e) {

					e.printStackTrace();

				}

				System.out.println("订阅消息");

				jedis.subscribe(listener, "TestQueue");

			}

		}).start();

	}

}
