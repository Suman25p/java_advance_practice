package com.kodewala.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.order.entity.OrderEntity;
import com.kodewala.order.kafka.service.KafkaProducerService;
import com.kodewala.order.repository.OrderRepositoy;
import com.kodewala.order.request.OrderRequest;

@Service
public class OrderService {

	@Autowired
    OrderRepositoy orderRepositoy;

    @Autowired
    KafkaProducerService kafkaProducerService;

    public void placeOrder(OrderRequest request) {

        // Create Entity
        OrderEntity entity = new OrderEntity();

        entity.setItemName(request.getItemName());
        entity.setStatus(request.getStatus());

        // Save Into Database
        orderRepositoy.save(entity);

        // Kafka Message
        String message =
                request.getItemName()
                + " "
                + request.getStatus();

        kafkaProducerService.sendMessage(
                "order-placed",
                message);

        System.out.println(
                "Order Created Successfully");
    }
}
