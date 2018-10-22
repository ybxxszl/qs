package com.wjy.test.queue.ps;

import com.wjy.util.PropertiesUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisFactory {

	private static String host;
	private static String port;
	private static String password;
	private static String timeOut;
	private static String database;
	private static String maxTotal;
	private static String maxIdle;
	private static String maxWaitMillis;
	private static String testOnBorrow;
	private static String testOnReturn;

	private static JedisPool jedisPool;

	private static Jedis jedis;

	static {

		host = PropertiesUtil.getValue("redis.host");
		port = PropertiesUtil.getValue("redis.port");
		password = PropertiesUtil.getValue("redis.password");
		timeOut = PropertiesUtil.getValue("redis.timeOut");
		database = PropertiesUtil.getValue("redis.database");
		maxTotal = PropertiesUtil.getValue("redis.pool.maxTotal");
		maxIdle = PropertiesUtil.getValue("redis.pool.maxIdle");
		maxWaitMillis = PropertiesUtil.getValue("redis.pool.maxWaitMillis");
		testOnBorrow = PropertiesUtil.getValue("redis.pool.testOnBorrow");
		testOnReturn = PropertiesUtil.getValue("redis.pool.testOnReturn");

		JedisPoolConfig config = new JedisPoolConfig();

		config.setMaxTotal(Integer.valueOf(maxTotal));
		config.setMaxIdle(Integer.valueOf(maxIdle));
		config.setMaxWaitMillis(Long.valueOf(maxWaitMillis));
		config.setTestOnBorrow(Boolean.valueOf(testOnBorrow));
		config.setTestOnReturn(Boolean.valueOf(testOnReturn));

		jedisPool = new JedisPool(config, host, Integer.valueOf(port), Integer.valueOf(timeOut), password,
				Integer.valueOf(database));

		jedis = jedisPool.getResource();

	}

	public static JedisPool getJedisPool() {

		return jedisPool;

	}

	public static Jedis getJedis() {

		return jedis;

	}

}
