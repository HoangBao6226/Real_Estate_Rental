package com.javaweb.service.implement;

import com.javaweb.entity.AccomEntity;
import com.javaweb.entity.DetailStatusEntity;
import com.javaweb.entity.StatusEntity;
import com.javaweb.repository.itface.AccomRepository;
import com.javaweb.repository.itface.DetailStatusRepository;
import com.javaweb.repository.itface.StatusRepository;
import com.javaweb.service.itface.DetailStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DetailStatusSerImplement implements DetailStatusService {

    @Autowired
    private AccomRepository accomRepository;

    @Autowired
    private DetailStatusRepository detailStatusRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public void updateStatusAvailable(int accomID) {

        AccomEntity ac = accomRepository.findById(accomID).get();
        StatusEntity st = statusRepository.findById(1).get();
        DetailStatusEntity detailStatusEntity = detailStatusRepository.findByaccommodationID(ac);
        detailStatusEntity.setStatusID(st);
        detailStatusEntity.setStartDate(null);
        detailStatusEntity.setEndDate(null);
        detailStatusRepository.save(detailStatusEntity);
    }

    @Override
    public void updateStatusUnavailable(int accomID) {

        AccomEntity ac = accomRepository.findById(accomID).get();
        StatusEntity st = statusRepository.findById(2).get();
        DetailStatusEntity detailStatusEntity = detailStatusRepository.findByaccommodationID(ac);
        detailStatusEntity.setStatusID(st);
        detailStatusEntity.setStartDate(null);
        detailStatusEntity.setEndDate(null);
        detailStatusRepository.save(detailStatusEntity);
    }

    @Override
    public void updateStatusOccupied(int accomID, LocalDateTime startDate, LocalDateTime endDate) {

        AccomEntity ac = accomRepository.findById(accomID).get();
        StatusEntity st = statusRepository.findById(3).get();
        DetailStatusEntity detailStatusEntity = detailStatusRepository.findByaccommodationID(ac);
        detailStatusEntity.setStatusID(st);
        detailStatusEntity.setStartDate(startDate);
        detailStatusEntity.setEndDate(endDate);
        detailStatusRepository.save(detailStatusEntity);
    }
}
