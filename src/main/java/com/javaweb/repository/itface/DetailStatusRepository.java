package com.javaweb.repository.itface;

import com.javaweb.entity.AccomEntity;
import com.javaweb.entity.DetailStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailStatusRepository extends JpaRepository<DetailStatusEntity, Integer> {
	
	DetailStatusEntity findByaccommodationID(AccomEntity accomID);
}
