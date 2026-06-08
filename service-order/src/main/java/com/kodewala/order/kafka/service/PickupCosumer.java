package com.kodewala.order.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;

public class PickupCosumer {
	 
	 @KafkaListener(
			 topics = "order-placed",
			 groupId = "pickup-group")
	 public void cosume(String message) {
		 System.out.println("Pickup Assigned: "+ message);
	 }
}
