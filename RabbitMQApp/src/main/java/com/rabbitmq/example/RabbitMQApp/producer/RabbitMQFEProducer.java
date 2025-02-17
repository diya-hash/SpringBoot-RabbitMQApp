package com.rabbitmq.example.RabbitMQApp.producer;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQFEProducer {
	private final RabbitTemplate rabbitTemplate;

	public RabbitMQFEProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendMessageToFEQueues(List<String> messages) {
		for (String message : messages) {
			rabbitTemplate.convertAndSend("Fanout-Exchange", "", message);
		}
	}
}
