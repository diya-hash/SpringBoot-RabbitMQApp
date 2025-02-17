package com.rabbitmq.example.RabbitMQApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.example.RabbitMQApp.producer.RabbitMQTEProducer;

@RestController
@RequestMapping("/api/TE")
public class TEMessageController {
	private final RabbitMQTEProducer teProducer;

	public TEMessageController(RabbitMQTEProducer teProducer) {
		this.teProducer = teProducer;
	}

	@PostMapping("/messages")
	public String sendMessageToTopicQueues(@RequestBody MessageRequest request, @RequestParam("key") String key) {
		teProducer.sendMessageToTopicQueues(request.getMessages(), key);
		return "message sent to Topic Exchange Queue";
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
