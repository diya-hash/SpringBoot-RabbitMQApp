package com.rabbitmq.example.RabbitMQApp.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;

@Service
public class RabbitMQDEMobileConsumer {

	@RabbitListener(queues = "Mobile", ackMode = "MANUAL") 
	 public void receiveMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
	    try {
	        System.out.println("Received messagein Mobile: " + message);
	        // ✅ Manually acknowledge the message
	        channel.basicAck(tag, false);
	        System.out.println("Message acknowledged!");
	    } catch (Exception e) {
	        try {
	            // ❌ Reject message if processing fails (Requeue = false means it will be discarded)
	            channel.basicNack(tag, false, false);
	            System.out.println("Message rejected!");
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	}
}
