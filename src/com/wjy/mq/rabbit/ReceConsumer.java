package com.wjy.mq.rabbit;

import java.io.IOException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

public class ReceConsumer extends DefaultConsumer {

	public ReceConsumer(Channel channel) {
		super(channel);
	}

	@Override
	public void handleConsumeOk(String consumerTag) {
		System.out.println("handleConsumeOk: " + consumerTag);
	}

	@Override
	public void handleCancelOk(String consumerTag) {
		System.out.println("handleCancelOk: " + consumerTag);
	}

	@Override
	public void handleCancel(String consumerTag) throws IOException {
		System.out.println("handleCancel: " + consumerTag);
	}

	@Override
	public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
			throws IOException {
		System.out.println("handleDelivery: " + consumerTag + " " + envelope + " " + properties);
		System.out.println("message: " + new String(body));
	}

	@Override
	public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {
		System.out.println("handleShutdownSignal: " + consumerTag + " " + sig);
	}

	@Override
	public void handleRecoverOk(String consumerTag) {
		System.out.println("handleRecoverOk: " + consumerTag);
	}

}
