package com.rabbitmq.example.RabbitMQApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.example.RabbitMQApp.producer.RabbitMQFEProducer;

@RestController
@RequestMapping("/api/fanout-exchange/messages")
public class FEMessageController {
	private final RabbitMQFEProducer feProducer;

	public FEMessageController(RabbitMQFEProducer feProducer) {
		this.feProducer = feProducer;
	}

	@PostMapping
	public String sendMessageToFEQueues(@RequestBody MessageRequest request) {
		feProducer.sendMessageToFEQueues(request.getMessages());
		return "message sent to all fanout Queues";
	}

	static class MessageRequest {
		private List<String> messages;

		public List<String> getMessages() {
			return messages;
		}

		public void setMessages(List<String> messages) {
			this.messages = messages;
		}
	}
}
