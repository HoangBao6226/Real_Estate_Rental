package com.javaweb.repository.itface;

import com.javaweb.entity.AccomEntity;
import com.javaweb.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {

    List<ReservationEntity> findByAccommodationID(AccomEntity accommodationID);
}
