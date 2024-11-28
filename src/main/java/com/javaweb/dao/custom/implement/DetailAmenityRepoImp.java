package com.javaweb.dao.custom.implement;

import java.util.List;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.DetailAmenityEntity;

@Repository
public class DetailAmenityRepoImp {

	@PersistenceContext
	private EntityManager entityManager;

//	@Override
	public List<DetailAmenityEntity> findAllById(int accomID) {

		String sql = "select * from detailamenity where accommodationID = " + accomID;
		Query query = entityManager.createNativeQuery(sql, DetailAmenityEntity.class);
		return query.getResultList();
	}
}
