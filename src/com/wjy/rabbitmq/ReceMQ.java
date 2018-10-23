package com.wjy.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class ReceMQ {

	public static void main(String[] args) throws IOException, TimeoutException {

		Connection connection = ConnectionFactoryUtil.getConnection();
		Channel channel = connection.createChannel();

		/*
		 * 声明队列
		 * 
		 * @queue 队列名称
		 * 
		 * @durable 是否持久化，即服务器重启时生存
		 * 
		 * @exclusive 独占队列，创建者可以使用的私有队列，断开后自动删除
		 * 
		 * @autoDelete 所有消费者客户端断开后是否自动删除
		 * 
		 * @arguments 其他属性
		 */
		channel.queueDeclare("TestQueue", false, false, false, null);

		ReceConsumer consumer = new ReceConsumer(channel);

		// 消息确认机制
		channel.basicConsume("TestQueue", true, consumer);

	}

}
