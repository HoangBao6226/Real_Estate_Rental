package com.javaweb.repository.itface;

import com.javaweb.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {
}
