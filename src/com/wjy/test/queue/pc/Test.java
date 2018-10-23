package com.wjy.test.queue.pc;

import redis.clients.jedis.Jedis;

public class Test {

	public static void main(String[] args) {

		Jedis jedis1 = JedisFactory.getJedis();
		Jedis jedis2 = JedisFactory.getJedis();

		Pusher pusher = new Pusher();
		Poper poper = new Poper();

		pusher.push(jedis1);
		poper.pop(jedis2);

	}

}
