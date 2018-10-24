package com.wjy.mq.rabbitmq;

public class MQInfo {

	private static final String QUEUE_NAME = "TestQueue";

	private static final String FANOUT_EXCHANGE_NAME = "FANOUT_EXCHANGE";
	private static final String DIRECT_EXCHANGE_NAME = "DIRECT_EXCHANGE";
	private static final String TOPIC_EXCHANGE_NAME = "TOPIC_EXCHANGE";

	public static String getQueueName() {
		return QUEUE_NAME;
	}

	public static String getFanoutExchangeName() {
		return FANOUT_EXCHANGE_NAME;
	}

	public static String getDirectExchangeName() {
		return DIRECT_EXCHANGE_NAME;
	}

	public static String getTopicExchangeName() {
		return TOPIC_EXCHANGE_NAME;
	}

	private static final String[] ROUTINGKEY = { "info", "error" };

	public static String[] getRoutingkey() {
		return ROUTINGKEY;
	}

}
