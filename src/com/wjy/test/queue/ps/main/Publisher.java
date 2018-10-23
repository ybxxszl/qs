package com.wjy.test.queue.ps.main;

import com.wjy.jedis.RedisUtil;

public class Publisher {

	public static int publish(String channel, String message) {

		int num = RedisUtil.publish(channel, message);

		return num;

	}

}
