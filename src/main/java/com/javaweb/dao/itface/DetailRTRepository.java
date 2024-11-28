package com.javaweb.dao.itface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.entity.AccomEntity;
import com.javaweb.entity.DetailRentTypeEntity;
import com.javaweb.entity.id.DetailRentTypeID;

public interface DetailRTRepository extends JpaRepository<DetailRentTypeEntity, DetailRentTypeID> {
	
	List<DetailRentTypeEntity> findAllByaccommodationID(AccomEntity accomID);
}
