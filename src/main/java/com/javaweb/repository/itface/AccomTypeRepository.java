package com.javaweb.repository.itface;

import com.javaweb.entity.AccomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccomTypeRepository extends JpaRepository<AccomTypeEntity, Integer> {

}