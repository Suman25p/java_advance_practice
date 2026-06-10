package com.project.delivery;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DeliveryKafkaListener {
	@KafkaListener(topics = "order-confirmedd", groupId = "delivery-group")
	public void consume(String message) {
		 System.out.println("Order confirmed out for delivery:");
		    System.out.println(message);
	
	}
}
