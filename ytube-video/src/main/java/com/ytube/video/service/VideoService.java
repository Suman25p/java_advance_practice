package com.ytube.video.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytube.video.entity.VideoEntity;
import com.ytube.video.kafka.producer.VideoProducer;
import com.ytube.video.repository.VideoRepository;
import com.ytube.video.request.VideoRequest;

@Service
public class VideoService {
	@Autowired
    private VideoRepository videoRepository;

    @Autowired
    private VideoProducer videoProducer;

    public void uploadVideo(
            VideoRequest request) {

        VideoEntity entity =
                new VideoEntity();

        entity.setTitle(
                request.getTitle());

        entity.setChannelName(
                request.getChannelName());

        entity.setCategory(
                request.getCategory());

        entity.setStatus(
                request.getStatus());

        videoRepository.save(entity);

        videoProducer.publish(request);

        System.out.println(
                "Video Saved Successfully");
    }
}
