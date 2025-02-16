package com.rabbitmq.example.RabbitMQApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rabbitmq.example.RabbitMQApp.producer.RabbitMQDirectExchangeProducer;

@RestController
@RequestMapping("/DE/messages")
public class DEMessageController {
	private final RabbitMQDirectExchangeProducer deProducer;
	
	
	public DEMessageController(RabbitMQDirectExchangeProducer deProducer) {
		this.deProducer = deProducer;
	}
	
	@PostMapping
	public String sendMessageToMobile(@RequestBody MessageRequest request) {
		deProducer.sendMessageToMobile(request.getMessages());
		return "message sent to Mobile Queue";
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
