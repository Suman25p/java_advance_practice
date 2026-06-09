package com.ytube.video.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ytube.video.request.VideoRequest;

@Service
public class NotificationConsumer {
	@KafkaListener(
            topics = "video-uploaded",
            groupId = "notification-group")
    public void consume(
            VideoRequest request) {

        System.out.println(
                "Notification Service");

        System.out.println(
                request.getTitle());

        System.out.println(
                "Notification Sent");
    }
}
