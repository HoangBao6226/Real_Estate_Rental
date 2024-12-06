package com.javaweb.repository.itface;

import com.javaweb.entity.LesseeEntity;
import com.javaweb.entity.LessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessorRepository extends JpaRepository<LessorEntity, Integer> {

    LessorEntity findByEmail(String email);

}
