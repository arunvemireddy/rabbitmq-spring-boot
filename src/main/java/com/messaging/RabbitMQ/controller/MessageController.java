package com.messaging.RabbitMQ.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.messaging.RabbitMQ.publisher.RabbitMQProducer;

@RestController
@RequestMapping("/api")
public class MessageController {
	
	private RabbitMQProducer producer;

	public MessageController(RabbitMQProducer producer) {
		this.producer = producer;
	}
	@GetMapping(path = "/check")
	public ResponseEntity<String> check(){
		return ResponseEntity.ok("rabbitmq working!!");
	}
	
	@GetMapping(path = "/publish")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
		producer.sendMessage(message);
		return ResponseEntity.ok("message sent to rabbitmq");
	}

}
