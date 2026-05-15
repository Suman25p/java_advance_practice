package com.kodewala.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodewala.example.entity.LocationEntity;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Long>{

}
