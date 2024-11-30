package com.javaweb.dao.itface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.entity.AccomEntity;
import com.javaweb.entity.DetailAmenityEntity;
import com.javaweb.entity.id.DetailAmenityID;

public interface DetailAmenityRepository extends JpaRepository<DetailAmenityEntity, Integer> {
	
	List<DetailAmenityEntity> findAllByaccommodationID(AccomEntity accomID);
}
