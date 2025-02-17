package com.rabbitmq.example.RabbitMQApp.producer;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQDEProducer {
	private final RabbitTemplate rabbitTemplate;

	public RabbitMQDEProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendMessageToMobile(List<String> messages) {
		for (String message : messages) {
			rabbitTemplate.convertAndSend("Direct-Exchange", "mobile", message);
		}
	}

	public void sendMessageToTV(List<String> messages) {
		for (String message : messages) {
			rabbitTemplate.convertAndSend("Direct-Exchange", "tv", message);
		}

	}

	public void sendMessageToAC(List<String> messages) {
		for (String message : messages) {
			rabbitTemplate.convertAndSend("Direct-Exchange", "ac", message);
		}
	}
}
