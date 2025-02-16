package com.rabbitmq.example.RabbitMQApp.controller;


import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.example.RabbitMQApp.producer.RabbitMQProducer;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
	
	private final RabbitMQProducer producer;
	
	public MessageController(RabbitMQProducer producer) {
		this.producer = producer;
	}
	
	@PostMapping
	public String sendMessage(@RequestBody MessageRequest request ) {
		producer.sendMessage(request.getMessages());
		return "message sent: ";
	}
	
	static class MessageRequest{
		private List<String> messages;
		
		public List<String>getMessages() {
			return messages;
		}
		public void setMessages(List<String> messages) {
			this.messages = messages;
		}
	}
}

