package com.kodewala.order.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {
//
//    @KafkaListener(
//            topics = "order-confirmed",
//            groupId = "notification-group")
//    public void consume(String message) {
//
//        System.out.println(
//                "Notification Service Received : "
//                + message);
//
//        System.out.println(
//                "Email/SMS Sent Successfully");
//    }
}
