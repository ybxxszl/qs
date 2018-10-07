package com.wjy.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {

	private static String url;

	private static Jedis jedis = null;
	private static JedisPool jedisPool = null;
	private static JedisPoolConfig jedisPoolConfig = null;

	static {

		url = PropertiesUtil.getValue("redis.url");

	}

	public void open() {

		jedisPoolConfig = new JedisPoolConfig();

		jedisPool = new JedisPool(jedisPoolConfig, url);
		jedis = jedisPool.getResource();

	}

	public void close() {

		jedis.close();

	}

}
