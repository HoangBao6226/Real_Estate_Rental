package com.javaweb.repository.itface;

import com.javaweb.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
