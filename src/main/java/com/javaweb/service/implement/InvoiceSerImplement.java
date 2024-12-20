package com.javaweb.service.implement;

import com.javaweb.entity.*;
import com.javaweb.repository.itface.AccomRepository;
import com.javaweb.repository.itface.AccountRepository;
import com.javaweb.repository.itface.InvoiceRepository;
import com.javaweb.repository.itface.RentTypeRepository;
import com.javaweb.service.itface.InvoiceService;
import jakarta.transaction.Transactional;
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
    public InvoiceEntity saveInvoice(Map<String, Object> params, String username, boolean isPaymentSuccessful) {

        if (!isPaymentSuccessful) {
            throw new RuntimeException("Payment failed. Deposit process aborted.");
        }

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

        try {
            AccomEntity accomEntity = accomRepository.findAvailableByaccommodationID(accomID);

            RentTypeEntity rentTypeEntity = rentTypeRepository.findById(rtID).get();
            AccountEntity accountEntity = accountRepository.findByUsername(username);
            LesseeEntity lesseeID = accountEntity.getLesseeID();

            InvoiceEntity invoiceEntity = new InvoiceEntity();
            invoiceEntity.setAccommodationID(accomEntity);
            invoiceEntity.setRentTypeID(rentTypeEntity);
            invoiceEntity.setLesseeID(lesseeID);
            invoiceEntity.setTotalPrice(price);
            invoiceEntity.setInvoiceDate(date);
            invoiceEntity.setStartDate(startDate);
            invoiceEntity.setEndDate(endDate);

            accomEntity.setStatus(AccomEntity.Status.Occupied);
            accomRepository.save(accomEntity);

            return invoiceRepository.save(invoiceEntity);

        } catch (Exception e) {
            throw new RuntimeException("Accommodation is not available for deposit");
        }
    }
}
