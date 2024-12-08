package com.javaweb.service.itface;

import com.javaweb.service.model.RentTypeDTO;

public interface RentTypeService {

    RentTypeDTO findRentTypeByName(String name);
}
