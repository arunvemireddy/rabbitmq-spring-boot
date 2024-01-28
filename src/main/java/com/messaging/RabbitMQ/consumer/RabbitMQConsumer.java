package com.messaging.RabbitMQ.consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQConsumer {

	private static Logger log = LogManager.getLogger(RabbitMQConsumer.class);
	
	@RabbitListener(queues = "${rabbitmq.queue.name}")
	public void consumeMessage(String message) {
		log.info("received message -> {}",message);
	}
	
	
}
