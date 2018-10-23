package com.wjy.mq.rabbitmq;

import java.io.IOException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class ReceConsumer extends DefaultConsumer {
	
	private Channel channel = null;

	public ReceConsumer(Channel channel) {
		super(channel);
		this.channel = channel;
	}

	@Override
	public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
			throws IOException {

		System.out.println("message: " + new String(body));
		
		channel.basicAck(envelope.getDeliveryTag(),false);

	}

}
