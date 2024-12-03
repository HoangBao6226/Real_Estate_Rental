package com.javaweb.service.itface;

import com.javaweb.entity.ReservationEntity;
import com.javaweb.service.model.ReservationDTO;

import java.util.Date;

public interface ReservationService {

    public ReservationEntity saveReservation(ReservationDTO reDTO, int accomID, int lesseeID);
}
