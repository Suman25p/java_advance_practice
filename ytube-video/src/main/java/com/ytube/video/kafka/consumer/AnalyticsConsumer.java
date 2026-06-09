package com.ytube.video.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ytube.video.request.VideoRequest;

@Service
public class AnalyticsConsumer {
	@KafkaListener(
            topics = "video-uploaded",
            groupId = "analytics-group")
    public void consume(
            VideoRequest request) {

        System.out.println(
                "Analytics Updated");

        System.out.println(
                request.getChannelName());
    }
}
