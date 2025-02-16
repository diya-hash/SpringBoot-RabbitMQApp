package com.rabbitmq.example.RabbitMQApp.producer;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQDirectExchangeProducer {
	private final RabbitTemplate rabbitTemplate;
	
	public RabbitMQDirectExchangeProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	public String sendMessageToMobile(List<String> messages) {
		for(String message : messages) {
			rabbitTemplate.convertAndSend("Direct-Exchange", "mobile", message);
		}
		return "messages sent successfully";
	}
}
