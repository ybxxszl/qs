package com.wjy.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wjy.jedis.JedisUtil;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

public class RedisUtil {

	/*
	 * List
	 */

	/**
	 * 将一至多个值插入到列表头部，值可以重复，返回列表的长度 列表不存在时，新建列表并插入
	 * 
	 * @param key
	 *            键
	 * @param values
	 *            值
	 * @return 列表的长度
	 */
	public static Long lpush(String key, String... values) {
		Jedis jedis = JedisUtil.getJedis();
		Long length = jedis.lpush(key, values);
		jedis.close();
		return length;
	}

	/**
	 * 将一至多个值插入到列表头部，值可以重复，返回列表的长度 列表不存在时，返回0
	 * 
	 * @param key
	 *            键
	 * @param values
	 *            值
	 * @return 列表的长度
	 */
	public static Long lpushx(String key, String... values) {
		Jedis jedis = JedisUtil.getJedis();
		Long length = jedis.lpushx(key, values);
		jedis.close();
		return length;
	}

	/**
	 * 将一至多个值插入到列表尾部，值可以重复，返回列表的长度 列表不存在时，新建列表并插入
	 * 
	 * @param key
	 *            键
	 * @param values
	 *            值
	 * @return 列表的长度
	 */
	public static Long rpush(String key, String... values) {
		Jedis jedis = JedisUtil.getJedis();
		Long length = jedis.rpush(key, values);
		jedis.close();
		return length;
	}

	/**
	 * 将一至多个值插入到列表尾部，值可以重复，返回列表的长度 列表不存在时，返回0
	 * 
	 * @param key
	 *            键
	 * @param values
	 *            值
	 * @return 列表的长度
	 */
	public static Long rpushx(String key, String value) {
		Jedis jedis = JedisUtil.getJedis();
		Long length = jedis.rpushx(key, value);
		jedis.close();
		return length;
	}

	/**
	 * 移除并返回列表第一个元素，当列表不存在或者为空时，返回null
	 * 
	 * @param key
	 *            键
	 * @return 元素的值
	 */
	public static String lpop(String key) {
		Jedis jedis = JedisUtil.getJedis();
		String value = jedis.lpop(key);
		jedis.close();
		return value;
	}

	/**
	 * 移除并返回列表最后一个元素，当列表不存在或者为空时，返回null
	 * 
	 * @param key
	 *            键
	 * @return 元素的值
	 */
	public static String rpop(String key) {
		Jedis jedis = JedisUtil.getJedis();
		String value = jedis.rpop(key);
		jedis.close();
		return value;
	}

	/**
	 * 移除并返回列表第一个元素
	 * 
	 * 当有多个键时，只要某个列表有值，立即返回 当所有列表不存在或者为空时，则会阻塞，直至有值返回或者超时
	 * 当超时时间到达时，所有列表不存在或者为空，则返回null
	 * 
	 * @param timeout
	 *            超时时间
	 * @param keys
	 *            键
	 * @return 元素的键和值
	 */
	public static List<String> blpop(int timeout, String... keys) {
		Jedis jedis = JedisUtil.getJedis();
		List<String> list = jedis.blpop(timeout, keys);
		jedis.close();
		return list;
	}

	/**
	 * 移除并返回列表最后一个元素
	 * 
	 * 当有多个键时，只要某个列表有值，立即返回 当所有列表不存在或者为空时，则会阻塞，直至有值返回或者超时
	 * 当超时时间到达时，所有列表不存在或者为空，则返回null
	 * 
	 * @param timeout
	 *            超时时间
	 * @param keys
	 *            键
	 * @return 元素的键和值
	 */
	public static List<String> brpop(int timeout, String... keys) {
		Jedis jedis = JedisUtil.getJedis();
		List<String> list = jedis.brpop(timeout, keys);
		jedis.close();
		return list;
	}

	/**
	 * 移除源列表的最后一个元素添加到目的列表并返回
	 * 
	 * 源列表不存在或者为空时，返回null 目的列表不存在时，则创建
	 * 
	 * @param srckey
	 *            源列表的键
	 * @param dstkey
	 *            目的列表的键
	 * @return 值
	 */
	public static String rpopLpush(String srckey, String dstkey) {
		Jedis jedis = JedisUtil.getJedis();
		String value = jedis.rpoplpush(srckey, srckey);
		jedis.close();
		return value;
	}

	/**
	 * 移除源列表的最后一个元素添加到目的列表并返回
	 * 
	 * 源列表不存在或者为空时，则会阻塞，直至有值添加并返回或者超时 当超时时间到达时，所有列表不存在或者为空，则返回null
	 * 
	 * @param source
	 *            源列表的键
	 * @param destination
	 *            目的列表的键
	 * @param timeout
	 *            超时时间
	 * @return 值
	 */
	public static String brpoplpush(String source, String destination, int timeout) {
		Jedis jedis = JedisUtil.getJedis();
		String value = jedis.brpoplpush(source, destination, timeout);
		jedis.close();
		return value;
	}

	/**
	 * 在列表中元素前面或者后面插入元素，返回列表的长度
	 * 
	 * @param key
	 *            键
	 * @param where
	 *            标识前面或者后面
	 * @param pivot
	 *            列表中元素值
	 * @param value
	 *            插入的元素值
	 * @return 列表的长度
	 */
	public static Long linsert(String key, LIST_POSITION where, String pivot, String value) {
		Jedis jedis = JedisUtil.getJedis();
		Long length = jedis.linsert(key, where, pivot, value);
		jedis.close();
		return length;
	}

	/**
	 * 获取List列表
	 * 
	 * @param key
	 * @param start
	 *            开始索引
	 * @param end
	 *            结束索引
	 * @return List<String>
	 */
	public static List<String> lrange(String key, long start, long end) {
		Jedis jedis = JedisUtil.getJedis();
		List<String> list = jedis.lrange(key, start, end);
		jedis.close();
		return list;
	}

	/**
	 * 通过索引获取列表中的元素
	 * 
	 * @param key
	 * @param index，索引，0表示最新的一个元素
	 * @return String
	 */
	public static String lindex(String key, long index) {
		Jedis jedis = JedisUtil.getJedis();
		String value = jedis.lindex(key, index);
		jedis.close();
		return value;
	}

	/**
	 * 获取列表长度，key为空时返回0
	 * 
	 * @param key
	 * @return Long
	 */
	public static Long llen(String key) {
		Jedis jedis = JedisUtil.getJedis();
		Long length = jedis.llen(key);
		jedis.close();
		return length;
	}

	/*
	 * SortedSet
	 */

	public static Map<String, Double> zrangeByScoreWithScores(String key) {

		Jedis jedis = JedisUtil.getJedis();

		Set<Tuple> set = jedis.zrangeByScoreWithScores(key, "-inf", "+inf");

		Map<String, Double> map = new HashMap<String, Double>();

		for (Tuple tuple : set) {

			map.put(tuple.getElement(), tuple.getScore());

		}

		return map;

	}

	public static Map<String, Double> zrangeByScoreWithScores(String key, String min, String max) {

		Jedis jedis = JedisUtil.getJedis();

		Set<Tuple> set = jedis.zrangeByScoreWithScores(key, min, max);

		Map<String, Double> map = new HashMap<String, Double>();

		for (Tuple tuple : set) {

			map.put(tuple.getElement(), tuple.getScore());

		}

		return map;

	}

	public static Map<String, Double> zrangeByScoreWithScores(String key, double min, double max) {

		Jedis jedis = JedisUtil.getJedis();

		Set<Tuple> set = jedis.zrangeByScoreWithScores(key, min, max);

		Map<String, Double> map = new HashMap<String, Double>();

		for (Tuple tuple : set) {

			map.put(tuple.getElement(), tuple.getScore());

		}

		return map;

	}

	public static Map<String, Double> zrangeByScoreWithScores(String key, int offset, int count) {

		Jedis jedis = JedisUtil.getJedis();

		Set<Tuple> set = jedis.zrangeByScoreWithScores(key, "-inf", "+inf", offset, count);

		Map<String, Double> map = new HashMap<String, Double>();

		for (Tuple tuple : set) {

			map.put(tuple.getElement(), tuple.getScore());

		}

		return map;

	}

	public static Map<String, Double> zrangeByScoreWithScores(String key, String min, String max, int offset,
			int count) {

		Jedis jedis = JedisUtil.getJedis();

		Set<Tuple> set = jedis.zrangeByScoreWithScores(key, min, max, offset, count);

		Map<String, Double> map = new HashMap<String, Double>();

		for (Tuple tuple : set) {

			map.put(tuple.getElement(), tuple.getScore());

		}

		return map;

	}

	public static Map<String, Double> zrangeByScoreWithScores(String key, double min, double max, int offset,
			int count) {

		Jedis jedis = JedisUtil.getJedis();

		Set<Tuple> set = jedis.zrangeByScoreWithScores(key, min, max, offset, count);

		Map<String, Double> map = new HashMap<String, Double>();

		for (Tuple tuple : set) {

			map.put(tuple.getElement(), tuple.getScore());

		}

		return map;

	}

	/**
	 * 根据key获取有序集合的数据总条数
	 * 
	 * @param key
	 * @return Long 有序集合的数据总条数
	 */
	public static Long zcard(String key) {

		Jedis jedis = JedisUtil.getJedis();

		return jedis.zcard(key);

	}

	/**
	 * 获取score在min和max中的数据的总条数，包含min和max
	 * 
	 * @param key
	 * @param min
	 * @param max
	 * @return Long 总条数
	 */
	public static Long zcount(String key, String min, String max) {

		Jedis jedis = JedisUtil.getJedis();

		return jedis.zcount(key, min, max);

	}

	/**
	 * 获取score在min和max中的数据的总条数，包含min和max
	 * 
	 * @param key
	 * @param min
	 * @param max
	 * @return Long 总条数
	 */
	public static Long zcount(String key, double min, double max) {

		Jedis jedis = JedisUtil.getJedis();

		return jedis.zcount(key, min, max);

	}

	/**
	 * 根据key和value获取数据在有序集合中的索引
	 * 
	 * @param key
	 * @param value
	 * @return Long 索引
	 */
	public static Long zrank(String key, String value) {

		Jedis jedis = JedisUtil.getJedis();

		return jedis.zrank(key, value);

	}

	/**
	 * 根据key和value获取score
	 * 
	 * @param key
	 * @param value
	 * @return Double score
	 */
	public static Double zscore(String key, String value) {

		Jedis jedis = JedisUtil.getJedis();

		return jedis.zscore(key, value);

	}

	/**
	 * 添加一条数据到有序集合
	 * 
	 * @param key
	 * @param value
	 * @param score
	 * @return Long 添加的条数
	 */
	public static Long zadd(String key, String value, double score) {

		Map<String, Double> map = new HashMap<String, Double>();

		map.put(value, score);

		return zadd(key, map);

	}

	/**
	 * 以Map集合的方式添加多条数据到有序集合
	 * 
	 * @param key
	 * @param map
	 * @return Long 添加的条数
	 */
	public static Long zadd(String key, Map<String, Double> map) {

		Jedis jedis = JedisUtil.getJedis();

		return jedis.zadd(key, map);

	}

	/**
	 * 根据key和value将score=score+add
	 * 
	 * @param key
	 * @param value
	 * @param add
	 * @return Double score
	 */
	public static Double zincrby(String key, String value, double add) {

		Jedis jedis = JedisUtil.getJedis();

		return jedis.zincrby(key, add, value);

	}

	/**
	 * 根据key和value删除一至多条数据
	 * 
	 * @param key
	 * @param values
	 * @return Long 删除的条数
	 */
	public static Long zrem(String key, String... values) {

		Jedis jedis = JedisUtil.getJedis();

		return jedis.zrem(key, values);

	}

}
