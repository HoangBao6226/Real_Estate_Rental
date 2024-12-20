package com.javaweb.repository.itface;

import java.util.List;

import com.javaweb.entity.EmployeeEntity;
import com.javaweb.entity.LessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.AccomEntity;

@Repository
public interface AccomRepository extends JpaRepository<AccomEntity, Integer> {
	
//	List<AccomEntity> findByaccommodationNameContaining(String s);

//	List<AccomEntity> findByaccommodationIDIn(List<Integer> ids);

    List<AccomEntity> findAllBySalesID(EmployeeEntity employeeEntity);

    List<AccomEntity> findAllByLessorID(LessorEntity lessorID);

    @Query("SELECT a FROM AccomEntity a WHERE a.accommodationID = :accommodationID AND a.status = 'Available'")
    AccomEntity findAvailableByaccommodationID(int accommodationID);
}