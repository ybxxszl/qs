package com.wjy.test.mq.rabbitmq.pc;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class SendMQ {

	@Test
	public void test() throws IOException, TimeoutException {

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

		for (int i = 1; i <= 10; i++) {

			/*
			 * 发送消息
			 * 
			 * @exchange 交换机名称
			 * 
			 * @routingKey 队列名称
			 * 
			 * @props 其他属性
			 * 
			 * @body 消息
			 */
			channel.basicPublish("", "TestQueue", null, ("Hello" + i).getBytes());

			System.out.println("第" + i + "条消息发送完成");

			try {

				Thread.sleep(1000);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

		channel.close();
		connection.close();

	}

}
