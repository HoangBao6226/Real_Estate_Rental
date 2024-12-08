package com.javaweb.service.implement;

import com.javaweb.entity.*;
import com.javaweb.repository.itface.AccomRepository;
import com.javaweb.repository.itface.AccountRepository;
import com.javaweb.repository.itface.InvoiceRepository;
import com.javaweb.repository.itface.RentTypeRepository;
import com.javaweb.service.itface.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@Service
public class InvoiceSerImplement implements InvoiceService {

    @Autowired
    private AccomRepository accomRepository;

    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public InvoiceEntity saveInvoice(Map<String, Object> params, String username) {

        Date date = new Date();
        String accomIDs = (String) params.get("accommodationID");
        String rtIDs = (String) params.get("rentTypeID");
        String prices = (String) params.get("price");
        String deposits = (String) params.get("deposit");
        String start = (String) params.get("startDate");
        String end = (String) params.get("endDate");

        int accomID = Integer.parseInt(accomIDs);
        int rtID = Integer.parseInt(rtIDs);
        int price = Integer.parseInt(prices);
        int deposit = Integer.parseInt(deposits);
        LocalDateTime startDate = LocalDateTime.parse(start);
        LocalDateTime endDate = LocalDateTime.parse(end);

        AccomEntity accomEntity = accomRepository.findById(accomID).get();
        RentTypeEntity rentTypeEntity = rentTypeRepository.findById(rtID).get();
        AccountEntity accountEntity = accountRepository.findByUsername(username);
        LesseeEntity lesseeID = accountEntity.getLesseeID();

        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setAccommodationID(accomEntity);
        invoiceEntity.setRentTypeID(rentTypeEntity);
        invoiceEntity.setLesseeID(lesseeID);
        invoiceEntity.setTotalPrice(price + deposit);
        invoiceEntity.setInvoiceDate(date);
        invoiceEntity.setStartDate(startDate);
        invoiceEntity.setEndDate(endDate);

        return invoiceRepository.save(invoiceEntity);
    }

    @Override
    public void updateStatusCanceled(int inID) {

        InvoiceEntity invoiceEntity = invoiceRepository.findById(inID).get();
        invoiceEntity.setStatus(InvoiceEntity.Status.Canceled);
        invoiceRepository.save(invoiceEntity);
    }
}
