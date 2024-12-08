package com.javaweb.service.implement;

import com.javaweb.entity.RentTypeEntity;
import com.javaweb.repository.itface.RentTypeRepository;
import com.javaweb.service.itface.RentTypeService;
import com.javaweb.service.model.RentTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentTypeSerImplement implements RentTypeService {

    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public RentTypeDTO findRentTypeByName(String name) {

        RentTypeEntity rentTypeEntity = rentTypeRepository.findByRentTypeName(name);
        RentTypeDTO rentTypeDTO = new RentTypeDTO();
        rentTypeDTO.setRentTypeID(rentTypeEntity.getRentTypeID());
        rentTypeDTO.setRentTypeName(rentTypeEntity.getRentTypeName());

        return rentTypeDTO;
    }
}
