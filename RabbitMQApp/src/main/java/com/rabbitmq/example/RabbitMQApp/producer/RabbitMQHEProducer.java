package com.rabbitmq.example.RabbitMQApp.producer;

import java.util.List;
import java.util.Map;

import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
@Service
public class RabbitMQHEProducer {
	private final RabbitTemplate rabbitTemplate;
	
	public RabbitMQHEProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	public void sendMessageToHeadersQueue(List<String> messages, Map<String, Object> headers) {
		
		MessagePostProcessor messagePostProcessor = msg -> {
			msg.getMessageProperties().getHeaders().putAll(headers);
			return msg;
		};
		for(String message : messages) {
			rabbitTemplate.convertAndSend("Headers-Exchange","", message, messagePostProcessor);
		}
	}
}
