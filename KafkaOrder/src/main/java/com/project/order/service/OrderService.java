package com.project.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.order.entity.OrderEntity;
import com.project.order.event.OrderEvent;
import com.project.order.kafka.producer.KafkaProducerService;
import com.project.order.repository.OrderRepository;
import com.project.order.request.OrderRequest;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private KafkaProducerService producer;

    public void placeOrder(OrderRequest request) {

        OrderEntity entity = new OrderEntity();

        entity.setCustomerName(request.getCustomerName());
        entity.setProductName(request.getProductName());
        entity.setStatus(request.getStatus());

        repository.save(entity);

        OrderEvent event = new OrderEvent();

        event.setOrderId(entity.getOrderId());
        event.setCustomerName(entity.getCustomerName());
        event.setProductName(entity.getProductName());
        event.setStatus(entity.getStatus());

        if ("CONFIRMED".equalsIgnoreCase(entity.getStatus())) {

            producer.publishOrderConfirmed(event);

            System.out.println(
                    "Confirmed Order Sent To Delivery Service");

        } else {

            producer.publishOrderStatus(event);

            System.out.println(
                    "Order Sent To Notification Service");
        }
    }
}