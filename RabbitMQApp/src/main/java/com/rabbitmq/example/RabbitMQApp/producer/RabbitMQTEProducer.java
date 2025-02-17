package com.rabbitmq.example.RabbitMQApp.producer;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQTEProducer {
	private final RabbitTemplate rabbitTemplate;

	public RabbitMQTEProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendMessageToTopicQueues(List<String> messages, String routingKey) {
		for (String message : messages) {
			rabbitTemplate.convertAndSend("Topic-Exchange", routingKey, message);
		}

	}

}
