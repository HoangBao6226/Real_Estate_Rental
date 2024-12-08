package com.javaweb.service.implement;

import com.javaweb.entity.AccomEntity;
import com.javaweb.entity.DetailRentTypeEntity;
import com.javaweb.entity.RentTypeEntity;
import com.javaweb.repository.itface.AccomRepository;
import com.javaweb.repository.itface.DetailRTRepository;
import com.javaweb.repository.itface.RentTypeRepository;
import com.javaweb.service.itface.DetailRTService;
import com.javaweb.service.model.DetailRTDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailRTSerImplement implements DetailRTService {

    @Autowired
    DetailRTRepository detailRTRepository;

    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Autowired
    private AccomRepository accomRepository;

    @Override
    public DetailRTDTO findByAccomIDAndRTName(int accomID, String rTName) {

        AccomEntity accom = accomRepository.findById(accomID).get();
        RentTypeEntity rt = rentTypeRepository.findByRentTypeName(rTName);

        DetailRentTypeEntity de = detailRTRepository.findByAccommodationIDAndRentTypeID(accom, rt);
        DetailRTDTO dto = new DetailRTDTO();
        dto.setPrice(de.getPrice());
        dto.setDeposit(de.getDeposit());

        return dto;
    }
}
