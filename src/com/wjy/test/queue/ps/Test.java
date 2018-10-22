package com.wjy.test.queue.ps;

import redis.clients.jedis.Jedis;

public class Test {

	public static void main(String[] args) {

		Jedis jedis1 = JedisFactory.getJedisPool().getResource();
		Jedis jedis2 = JedisFactory.getJedisPool().getResource();

		JedisPubSubListener listener = new JedisPubSubListener();

		Publisher publisher = new Publisher();
		Subscriber subscriber = new Subscriber();

		publisher.publish(jedis1);
		subscriber.subscrib(jedis2, listener);

	}

}
