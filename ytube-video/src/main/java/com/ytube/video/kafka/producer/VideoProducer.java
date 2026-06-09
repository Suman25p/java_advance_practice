package com.ytube.video.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ytube.video.request.VideoRequest;

@Service
public class VideoProducer {
	@Autowired
    private KafkaTemplate<String, VideoRequest> kafkaTemplate;
	
    public void publish(VideoRequest request) {

        kafkaTemplate.send(
                "video-uploaded",
                request);

        System.out.println(
                "Video Event Published");
    }
}
