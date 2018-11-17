package com.wjy.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wjy.jedis.JedisUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.BinaryClient.LIST_POSITION;

public class RedisUtil {

	/*
	 * List
	 */

	/**
	 * 将一个值插入到列表头部，value可以重复，返回列表的长度
	 * 
	 * @param key
	 * @param value
	 *            String
	 * @return 返回List的长度
	 */
	public static Long lpush(String key, String value) {
		Jedis jedis = JedisUtil.getJedis();
		Long length = jedis.lpush(key, value);
		jedis.close();
		return length;
	}

	/**
	 * 将多个值插入到列表头部，value可以重复
	 * 
	 * @param key
	 * @param values
	 *            String[]
	 * @return 返回List的数量size
	 */
	public static Long lpush(String key, String[] values) {
		Jedis jedis = JedisUtil.getJedis();
		Long size = jedis.lpush(key, values);
		jedis.close();
		// System.out.println(result);
		return size;
	}

	/**
	 * 获取List列表
	 * 
	 * @param key
	 * @param start
	 *            long，开始索引
	 * @param end
	 *            long， 结束索引
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
		String str = jedis.lindex(key, index);
		jedis.close();
		return str;
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

	/**
	 * 在列表的元素前或者后插入元素，返回List的长度
	 * 
	 * @param key
	 * @param where
	 *            LIST_POSITION
	 * @param pivot
	 *            以该元素作为参照物，是在它之前，还是之后（pivot：枢轴;中心点，中枢;[物]支点，支枢;[体]回转运动。）
	 * @param value
	 * @return Long
	 */
	public static Long linsert(String key, LIST_POSITION where, String pivot, String value) {
		Jedis jedis = JedisUtil.getJedis();
		Long length = jedis.linsert(key, where, pivot, value);
		jedis.close();
		return length;
	}

	/**
	 * 将一个或多个值插入到已存在的列表头部，当成功时，返回List的长度；当不成功（即key不存在时，返回0）
	 * 
	 * @param key
	 * @param value
	 *            String
	 * @return Long
	 */
	public static Long lpushx(String key, String value) {
		Jedis jedis = JedisUtil.getJedis();
		Long length = jedis.lpushx(key, value);
		jedis.close();
		return length;
	}

	/**
	 * 将一个或多个值插入到已存在的列表头部，当成功时，返回List的长度；当不成功（即key不存在时，返回0）
	 * 
	 * @param key
	 * @param values
	 *            String[]
	 * @return Long
	 */
	public static Long lpushx(String key, String[] values) {
		Jedis jedis = JedisUtil.getJedis();
		Long length = jedis.lpushx(key, values);
		jedis.close();
		return length;
	}

	/**
	 * 移除列表元素，返回移除的元素数量
	 * 
	 * @param key
	 * @param count，标识，表示动作或者查找方向
	 *            <li>当count=0时，移除所有匹配的元素；</li>
	 *            <li>当count为负数时，移除方向是从尾到头；</li>
	 *            <li>当count为正数时，移除方向是从头到尾；</li>
	 * @param value
	 *            匹配的元素
	 * @return Long
	 */
	public static Long lrem(String key, long count, String value) {
		Jedis jedis = JedisUtil.getJedis();
		Long length = jedis.lrem(key, count, value);
		jedis.close();
		return length;
	}

	/**
	 * 通过索引设置列表元素的值，当超出索引时会抛错。成功设置返回true
	 * 
	 * @param key
	 * @param index
	 *            索引
	 * @param value
	 * @return boolean
	 */
	public static boolean lset(String key, long index, String value) {
		Jedis jedis = JedisUtil.getJedis();
		String statusCode = jedis.lset(key, index, value);
		jedis.close();
		if ("ok".equalsIgnoreCase(statusCode)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。
	 * 
	 * @param key
	 * @param start
	 *            <li>可以为负数（-1是列表的最后一个元素，-2是列表倒数第二的元素。）</li>
	 *            <li>如果start大于end，则返回一个空的列表，即列表被清空</li>
	 * @param end
	 *            <li>可以为负数（-1是列表的最后一个元素，-2是列表倒数第二的元素。）</li>
	 *            <li>可以超出索引，不影响结果</li>
	 * @return boolean
	 */
	public static boolean ltrim(String key, long start, long end) {
		Jedis jedis = JedisUtil.getJedis();
		String statusCode = jedis.ltrim(key, start, end);
		jedis.close();
		if ("ok".equalsIgnoreCase(statusCode)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 移出并获取列表的第一个元素，当列表不存在或者为空时，返回Null
	 * 
	 * @param key
	 * @return String
	 */
	public static String lpop(String key) {
		Jedis jedis = JedisUtil.getJedis();
		String value = jedis.lpop(key);
		jedis.close();
		return value;
	}

	/**
	 * 移除并获取列表最后一个元素，当列表不存在或者为空时，返回Null
	 * 
	 * @param key
	 * @return String
	 */
	public static String rpop(String key) {
		Jedis jedis = JedisUtil.getJedis();
		String value = jedis.rpop(key);
		jedis.close();
		return value;
	}

	/**
	 * 在列表中的尾部添加一个个值，返回列表的长度
	 * 
	 * @param key
	 * @param value
	 * @return Long
	 */
	public static Long rpush(String key, String value) {
		Jedis jedis = JedisUtil.getJedis();
		Long length = jedis.rpush(key, value);
		jedis.close();
		return length;
	}

	/**
	 * 在列表中的尾部添加多个值，返回列表的长度
	 * 
	 * @param key
	 * @param values
	 * @return Long
	 */
	public static Long rpush(String key, String[] values) {
		Jedis jedis = JedisUtil.getJedis();
		Long length = jedis.rpush(key, values);
		jedis.close();
		return length;
	}

	/**
	 * 仅当列表存在时，才会向列表中的尾部添加一个值，返回列表的长度
	 * 
	 * @param key
	 * @param value
	 * @return Long
	 */
	public static Long rpushx(String key, String value) {
		Jedis jedis = JedisUtil.getJedis();
		Long length = jedis.rpushx(key, value);
		jedis.close();
		return length;
	}

	/**
	 * 移除列表的最后一个元素，并将该元素添加到另一个列表并返回
	 * 
	 * @param sourceKey
	 *            源列表的key，当源key不存在时，结果返回Null
	 * @param targetKey
	 *            目标列表的key，当目标key不存在时，会自动创建新的
	 * @return String
	 */
	public static String rpopLpush(String sourceKey, String targetKey) {
		Jedis jedis = JedisUtil.getJedis();
		String value = jedis.rpoplpush(sourceKey, targetKey);
		jedis.close();
		return value;
	}

	/**
	 * 移出并获取列表的【第一个元素】， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
	 * 
	 * @param timeout
	 *            单位为秒
	 * @param keys
	 *            <li>当有多个key时，只要某个key值的列表有内容，即马上返回，不再阻塞。</li>
	 *            <li>当所有key都没有内容或不存在时，则会阻塞，直到有值返回或者超时。</li>
	 *            <li>当超期时间到达时，keys列表仍然没有内容，则返回Null</li>
	 * @return List<String>
	 */
	public static List<String> blpop(int timeout, String... keys) {
		Jedis jedis = JedisUtil.getJedis();
		List<String> values = jedis.blpop(timeout, keys);
		jedis.close();
		return values;
	}

	/**
	 * 移出并获取列表的【最后一个元素】， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
	 * 
	 * @param timeout
	 *            单位为秒
	 * @param keys
	 *            <li>当有多个key时，只要某个key值的列表有内容，即马上返回，不再阻塞。</li>
	 *            <li>当所有key都没有内容或不存在时，则会阻塞，直到有值返回或者超时。</li>
	 *            <li>当超期时间到达时，keys列表仍然没有内容，则返回Null</li>
	 * @return List<String>
	 */
	public static List<String> brpop(int timeout, String... keys) {
		Jedis jedis = JedisUtil.getJedis();
		List<String> values = jedis.brpop(timeout, keys);
		jedis.close();
		return values;
	}

	/**
	 * 从列表中弹出列表最后一个值，将弹出的元素插入到另外一个列表中并返回它； 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
	 * 
	 * @param sourceKey
	 *            源列表的key，当源key不存在时，则会进行阻塞
	 * @param targetKey
	 *            目标列表的key，当目标key不存在时，会自动创建新的
	 * @param timeout
	 *            单位为秒
	 * @return String
	 */
	public static String brpopLpush(String sourceKey, String targetKey, int timeout) {
		Jedis jedis = JedisUtil.getJedis();
		String value = jedis.brpoplpush(sourceKey, targetKey, timeout);
		jedis.close();
		return value;
	}

	/*
	 * ZSet
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
