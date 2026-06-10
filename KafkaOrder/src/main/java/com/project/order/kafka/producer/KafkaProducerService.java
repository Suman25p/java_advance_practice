package com.project.order.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.project.order.event.OrderEvent;

@Service
public class KafkaProducerService {
	@Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void publishOrderStatus(
            OrderEvent event) {

        kafkaTemplate.send(
                "order-status",
                event);
    }

    public void publishOrderConfirmed(
            OrderEvent event) {

        kafkaTemplate.send(
                "order-confirmedd",
                event);
    }
}
