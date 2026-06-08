package com.kodewala.order.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

	@KafkaListener(
			topics  = "order-placed",
			groupId  =  "notification-group")
	
	public void cosume(String message) {
		System.out.println("Notification Sent: " + message);
	}
}
