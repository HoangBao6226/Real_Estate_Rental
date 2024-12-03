package com.javaweb.repository.itface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.entity.AmenityEntity;

public interface AmenityRepository extends JpaRepository<AmenityEntity, Integer> {

}
