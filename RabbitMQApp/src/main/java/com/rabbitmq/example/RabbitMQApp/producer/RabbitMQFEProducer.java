package com.rabbitmq.example.RabbitMQApp.producer;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQFanoutExchangeProducer {
	private final RabbitTemplate rabbitTemplate;
	
	public RabbitMQFanoutExchangeProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	public void sendMessageToFEQueues(List<String> messages) {
		for(String message : messages) {
			rabbitTemplate.convertAndSend("Fanout-Exchange", "", message);
		}
	}
}
