package com.javaweb.service.implement;

import com.javaweb.entity.AccomEntity;
import com.javaweb.entity.LesseeEntity;
import com.javaweb.entity.ReservationEntity;
import com.javaweb.repository.itface.AccomRepository;
import com.javaweb.repository.itface.LesseeRepository;
import com.javaweb.repository.itface.ReservationRepository;
import com.javaweb.repository.itface.UserRepository;
import com.javaweb.service.itface.ReservationService;
import com.javaweb.service.model.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReservationSerImplement implements ReservationService {

    @Autowired
    private ReservationRepository reRepository;

    @Autowired
    private AccomRepository accomRepository;

    @Autowired
    private LesseeRepository lesseeRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ReservationEntity saveReservation(ReservationDTO reDTO, int accomID, int lesseeID) {

        AccomEntity ac = accomRepository.findById(accomID).get();
        LesseeEntity le = lesseeRepository.findById(lesseeID).get();

        ReservationEntity reEntity = new ReservationEntity();
        reEntity.setAccommodationID(ac);
        reEntity.setLesseeID(le);
        reEntity.setViewDate(reDTO.getViewDate());
        reEntity.setNote(reDTO.getNote());
        return reRepository.save(reEntity);
    }
}
