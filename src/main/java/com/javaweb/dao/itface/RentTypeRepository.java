package com.javaweb.dao.itface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.entity.RentTypeEntity;

public interface RentTypeRepository extends JpaRepository<RentTypeEntity, Integer> {

}
