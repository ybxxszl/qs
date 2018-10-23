package com.wjy.test.mq.redismq.pc;

import redis.clients.jedis.Jedis;

public class Poper {

	public void pop(final Jedis jedis) {

		new Thread(new Runnable() {

			@Override
			public void run() {

				try {

					Thread.sleep(1000);

				} catch (InterruptedException e) {

					e.printStackTrace();

				}

				System.out.println("消费消息");

				while (true) {

					System.out.println(jedis.brpop(0, "TestQueue"));

				}

			}

		}).start();

	}

}
