package com.ytube.video.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ytube.video.request.VideoRequest;

@Service
public class RecommendationConsumer {
	@KafkaListener(
            topics = "video-uploaded",
            groupId = "recommendation-group")
    public void consume(
            VideoRequest request) {

        System.out.println(
                "Recommendation Updated");

        System.out.println(
                request.getCategory());
    }
}
