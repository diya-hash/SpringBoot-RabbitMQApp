package com.rabbitmq.example.RabbitMQApp.producer;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQTopicExchangeProducer {
	private final RabbitTemplate rabbitTemplate;
	
	public RabbitMQTopicExchangeProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	public void sendMessageToTopicQueues(List<String> messages, String routingKey) {
		for(String message : messages) {
			rabbitTemplate.convertAndSend("Topic-Exchange",routingKey, message);
		}

	}


}
