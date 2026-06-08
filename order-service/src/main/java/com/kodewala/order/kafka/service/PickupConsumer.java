package com.kodewala.order.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PickupConsumer {
	
	@KafkaListener(
            topics = "order-confirmed",
            groupId = "pickup-group")
    public void consume(String message) {

        System.out.println(
                "Pickup Service Received : "
                + message);

        System.out.println(
                "Pickup Assigned Successfully");
    }
}
