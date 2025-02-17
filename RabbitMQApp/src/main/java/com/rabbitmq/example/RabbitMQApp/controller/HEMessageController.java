package com.rabbitmq.example.RabbitMQApp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.example.RabbitMQApp.producer.RabbitMQHEProducer;

@RestController
@RequestMapping("/api/headers-exchange")
public class HEMessageController {
	private final RabbitMQHEProducer heProducer;
	
	
	public HEMessageController(RabbitMQHEProducer heProducer) {
		this.heProducer = heProducer;
	}
	
	@PostMapping("/messages")
	public String sendMessageToHeadersQueue(@RequestBody MessageRequest request) {
		heProducer.sendMessageToHeadersQueue(request.getMessages(), request.getHeaders());
		return "Message sent to Headers Exchange Queue";
	}

	static class MessageRequest{
		private List<String> messages;
		private Map<String, Object> headers;
		
		public List<String>getMessages() {
			return messages;
		}
		public void setMessages(List<String> messages) {
			this.messages = messages;
		}
		public Map<String, Object> getHeaders(){
			return headers;
		}
		public void setHeaders(Map<String, Object> headers) {
			this.headers = headers;
		}
	}
}
