package com.javaweb.service.implement.sales;

import com.javaweb.entity.AccomEntity;
import com.javaweb.entity.AccountEntity;
import com.javaweb.entity.EmployeeEntity;
import com.javaweb.entity.ReservationEntity;
import com.javaweb.repository.itface.AccomRepository;
import com.javaweb.repository.itface.AccountRepository;
import com.javaweb.repository.itface.ReservationRepository;
import com.javaweb.service.converter.AccomConverter;
import com.javaweb.service.itface.sales.Sales_ReservationService;
import com.javaweb.service.model.AccomDTO;
import com.javaweb.service.model.sales.Sales_ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Sales_ReservationSerImplement implements Sales_ReservationService {

    @Autowired
    private AccomRepository accomRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccomConverter accomConverter;

    @Override
    public List<Sales_ReservationDTO> findBySalesID(String username) {

        AccountEntity accountEntity = accountRepository.findByUsername(username);
        EmployeeEntity emEn = accountEntity.getEmployeeID();

        List<AccomEntity> accomEn = accomRepository.findAllBySalesID(emEn);

        List<ReservationEntity> reEns = new ArrayList<>();
        for(AccomEntity item : accomEn) {
            List<ReservationEntity> reEn = reservationRepository.findByAccommodationID(item);
            for(ReservationEntity item2 : reEn) {
                reEns.add(item2);
            }
        }

        List<Sales_ReservationDTO> rs = new ArrayList<>();
        for(ReservationEntity item3 : reEns) {
            Sales_ReservationDTO sr = new Sales_ReservationDTO();
            sr.setReservationID(item3.getReservationID());
            sr.setViewDate(item3.getViewDate());
            sr.setNote(item3.getNote());
            AccomEntity ac = accomRepository.findById(item3.getAccommodationID().getAccommodationID()).get();
            AccomDTO accomDTO = accomConverter.toAccomDTO(ac);
            sr.setAccom(accomDTO);
            sr.setLessee(item3.getLesseeID());
            rs.add(sr);
        }

        return rs;
    }
}
