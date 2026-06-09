package com.ytube.video.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ytube.video.entity.VideoEntity;

@Repository
public interface VideoRepository extends CrudRepository<VideoEntity, Long>{
	
}
