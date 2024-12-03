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

@Service
public class DetailStatusSerImplement implements DetailStatusService {

    @Autowired
    private AccomRepository accomRepository;
    @Autowired
    private DetailStatusRepository detailStatusRepository;
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public DetailStatusEntity updateStatusID(int accomID) {

        AccomEntity ac = accomRepository.findById(accomID).get();
        StatusEntity st = statusRepository.findById(2).get();
        DetailStatusEntity detailStatusEntity = detailStatusRepository.findByaccommodationID(ac);
        detailStatusEntity.setStatusID(st);
        return detailStatusRepository.save(detailStatusEntity);
    }
}
