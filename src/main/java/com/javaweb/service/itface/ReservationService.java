package com.javaweb.service.itface;

import com.javaweb.entity.ReservationEntity;
import com.javaweb.service.model.ReservationDTO;

public interface ReservationService {

    ReservationEntity saveReservation(ReservationDTO reDTO, int accomID, int lesseeID);
}