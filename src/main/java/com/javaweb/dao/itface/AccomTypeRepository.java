package com.javaweb.dao.itface;

import com.javaweb.entity.AccomEntity;
import com.javaweb.entity.AccomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccomTypeRepository extends JpaRepository<AccomTypeEntity, Integer> {

}