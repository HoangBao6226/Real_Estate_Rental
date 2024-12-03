package com.javaweb.repository.itface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.entity.AccomEntity;
import com.javaweb.entity.DetailAmenityEntity;

public interface DetailAmenityRepository extends JpaRepository<DetailAmenityEntity, Integer> {
	
	List<DetailAmenityEntity> findAllByaccommodationID(AccomEntity accomID);
}
