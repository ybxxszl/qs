package com.wjy.test.mq.rabbitmq;

public class MQInfo {

	private static final String QUEUE_NAME = "TestQueue";

	private static final String EXCHANGE_NAME = "TestEXCHANGE";

	public static String getQueueName() {
		return QUEUE_NAME;
	}

	public static String getExchangeName() {
		return EXCHANGE_NAME;
	}

}
