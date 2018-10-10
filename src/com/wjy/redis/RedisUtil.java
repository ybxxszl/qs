package com.wjy.redis;

import redis.clients.jedis.Jedis;

public class RedisUtil {

	public static void set(String key, String value, int seconds) {

		Jedis jedis = JedisPoolUtil.getInstance().getResource();

		jedis.set(key, value);

		jedis.expire(key, seconds);

		jedis.close();

	}

	public static void set(String key, String value) {

		Jedis jedis = JedisPoolUtil.getInstance().getResource();

		jedis.set(key, value);

		jedis.close();

	}

	public static String get(String key) {

		Jedis jedis = JedisPoolUtil.getInstance().getResource();

		String value = jedis.get(key);

		jedis.close();

		return value;

	}

}
