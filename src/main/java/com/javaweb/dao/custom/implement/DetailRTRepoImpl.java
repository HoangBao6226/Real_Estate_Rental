package com.javaweb.dao.custom.implement;

import java.util.List;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.DetailRentTypeEntity;

@Repository
public class DetailRTRepoImpl {

	@PersistenceContext
	private EntityManager entityManager;

//	@Override
	public List<DetailRentTypeEntity> findAllById(int accomID) {
		
		String sql = "select * from detailrenttype where accommodationID = " + accomID;
		Query query = entityManager.createNativeQuery(sql, DetailRentTypeEntity.class);
		return query.getResultList();
	}

}
