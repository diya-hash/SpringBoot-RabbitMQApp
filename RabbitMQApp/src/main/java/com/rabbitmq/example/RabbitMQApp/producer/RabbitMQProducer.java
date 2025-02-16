package com.rabbitmq.example.RabbitMQApp.producer;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {
	
	private final RabbitTemplate rabbitTemplate;
	private final String queueName = "Queue-1";
	
    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
	public String sendMessage(List<String> messages) {
		for(String message : messages) {
			rabbitTemplate.convertAndSend(queueName, message);
		}
		return "messages sent successfully";
	}
}
