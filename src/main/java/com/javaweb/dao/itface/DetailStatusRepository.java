package com.javaweb.dao.itface;

import com.javaweb.entity.AccomEntity;
import com.javaweb.entity.DetailAmenityEntity;
import com.javaweb.entity.DetailStatusEntity;
import com.javaweb.entity.id.DetailAmenityID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailStatusRepository extends JpaRepository<DetailStatusEntity, Integer> {
	
	List<DetailStatusEntity> findAllByaccommodationID(AccomEntity accomID);
}
