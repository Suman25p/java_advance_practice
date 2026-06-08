package com.kodewala.order.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

	@KafkaListener(
			topics = "order-placed",
			groupId = "payment-group")
	public void consume(String message) {
		 System.out.println("Payment Processing : "+ message);
	}
	
}
