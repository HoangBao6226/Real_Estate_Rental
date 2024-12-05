package com.javaweb.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "accommodationID")
    private AccomEntity accommodationID;

    @ManyToOne
    @JoinColumn(name = "lesseeID")
    private LesseeEntity lesseeID;

    @ManyToOne
    @JoinColumn(name = "rentTypeID")
    private RentTypeEntity rentTypeID;

    @OneToMany(mappedBy = "invoiceID")
    private List<PaymentEntity> listPay = new ArrayList<PaymentEntity>();

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public AccomEntity getAccommodationID() {
        return accommodationID;
    }

    public void setAccommodationID(AccomEntity accommodationID) {
        this.accommodationID = accommodationID;
    }

    public LesseeEntity getLesseeID() {
        return lesseeID;
    }

    public void setLesseeID(LesseeEntity lesseeID) {
        this.lesseeID = lesseeID;
    }

    public RentTypeEntity getRentTypeID() {
        return rentTypeID;
    }

    public void setRentTypeID(RentTypeEntity rentTypeID) {
        this.rentTypeID = rentTypeID;
    }

    public List<PaymentEntity> getListPay() {
        return listPay;
    }

    public void setListPay(List<PaymentEntity> listPay) {
        this.listPay = listPay;
    }
}
