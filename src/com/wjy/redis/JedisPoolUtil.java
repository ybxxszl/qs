package com.wjy.redis;

import com.wjy.util.PropertiesUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @date 2018年10月9日
 * @author ybxxszl
 * @description JedisPoolUtil工具类
 */
public class JedisPoolUtil {

	private static String url;

	private static Jedis jedis = null;
	private static JedisPool jedisPool = null;
	private static JedisPoolConfig jedisPoolConfig = null;

	static {

		url = PropertiesUtil.getValue("redis.url");

	}

	/**
	 * @date 2018年10月9日
	 * @author ybxxszl
	 * @description 打开Redis连接
	 */
	public static void open() {

		jedisPoolConfig = new JedisPoolConfig();

		jedisPool = new JedisPool(jedisPoolConfig, url);
		jedis = jedisPool.getResource();

	}

	/**
	 * @date 2018年10月9日
	 * @author ybxxszl
	 * @description 关闭Redis连接
	 */
	public static void close() {

		jedis.close();

	}

}
