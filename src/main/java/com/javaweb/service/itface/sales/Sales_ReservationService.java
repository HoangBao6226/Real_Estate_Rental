package com.javaweb.service.itface.sales;

import com.javaweb.service.model.sales.Sales_ReservationDTO;

import java.util.List;

public interface Sales_ReservationService {

    List<Sales_ReservationDTO> findBySalesID(String username);
}
