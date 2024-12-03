package com.javaweb.repository.itface;

import com.javaweb.entity.AccomTypeEntity;
import com.javaweb.entity.AdvantageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvantageRepository extends JpaRepository<AdvantageEntity, Integer> {
	
	List<AdvantageEntity> findAllByaccomTypeID(AccomTypeEntity accomTypeID);

}
