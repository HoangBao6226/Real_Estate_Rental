package com.javaweb.service.implement;

import com.javaweb.entity.AccomEntity;
import com.javaweb.entity.LesseeEntity;
import com.javaweb.entity.ReservationEntity;
import com.javaweb.repository.itface.AccomRepository;
import com.javaweb.repository.itface.LesseeRepository;
import com.javaweb.repository.itface.ReservationRepository;
import com.javaweb.service.itface.ReservationService;
import com.javaweb.service.model.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationSerImplement implements ReservationService {

    @Autowired
    private ReservationRepository reRepository;

    @Autowired
    private AccomRepository accomRepository;

    @Autowired
    private LesseeRepository lesseeRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public ReservationEntity saveReservation(ReservationDTO reDTO, int accomID, int lesseeID) {

        AccomEntity ac = accomRepository.findById(accomID).get();
        LesseeEntity le = lesseeRepository.findById(lesseeID).get();

        ReservationEntity reEntity = new ReservationEntity();
        reEntity.setAccommodationID(ac);
        reEntity.setLesseeID(le);
        reEntity.setViewDate(reDTO.getViewDate());
        reEntity.setViewTime(reDTO.getViewTime());
        reEntity.setNote(reDTO.getNote());
        reRepository.save(reEntity);
        // Gửi email chào mừng
        emailService.sendThankYouEmail(le.getEmail(), reEntity.getReservationID());
        return reEntity;
    }
}
