package com.messaging.RabbitMQ.publisher;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class RabbitMQProducer {
	
	private static Logger log = LogManager.getLogger(RabbitMQProducer.class);

	@Value("${rabbitmq.exchange.name}")
	private String exchange;

	@Value("${rabbitmq.routing.key}")
	private String routingKey;
	
	private RabbitTemplate rabbitTemplate;
	
			
	public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendMessage(String message) {
		
		 try {
	            log.info("Sending message - {}", message);
	            rabbitTemplate.convertAndSend(exchange, routingKey, message);
	            log.info("Message sent successfully");
	        } catch (AmqpException e) {
	            log.error("Error sending message: {}", e.getMessage(), e);
	        }
	}
}
