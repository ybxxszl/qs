package com.wjy.test.queue;

import com.wjy.jedis.RedisUtil;

public class Subscriber {

	public static void subscrib(JedisPubSubListener listener, String... messages) {

		RedisUtil.subscribe(listener, messages);

	}

}
