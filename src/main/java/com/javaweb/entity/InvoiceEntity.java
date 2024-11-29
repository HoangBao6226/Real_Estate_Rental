package com.javaweb.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "invoice")
public class InvoiceEntity {

    public enum Status {
        In_progress, Completed, Canceled;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceID;

    @Column(name = "totalPrice")
    private int totalPrice;

    @Column(name = "invoiceDate")
    private Date invoiceDate;

    @Column(name = "invoiceType")
    private String invoiceType;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "accommodationID")
    private int accommodationID;

    @Column(name = "lesseeID")
    private int lesseeID;

    @Column(name = "rentTypeID")
    private int rentTypeID;
}
