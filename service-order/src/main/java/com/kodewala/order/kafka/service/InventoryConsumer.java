package com.kodewala.order.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryConsumer {
	
	@KafkaListener(
			topics = "order-placed",
			groupId = "inventory-group")
	public void consume(String message) {
		System.out.println(
                "Inventory Updated : "
                + message);
	}
}
