package com.javaweb.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "payment")
public class PaymentEntity {

    public enum PaymentMethod {
        Cash, Bank_transfer;
    }

    public enum Status {
        Success, Failed, Pending, Refunded;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentID;

    @Column(name = "paymentAmount")
    private int paymentAmount;

    @Column(name = "fee")
    private int fee;

    @Column(name = "paymentMethod")
    private PaymentMethod paymentMethod;

    @Column(name = "paymentDate")
    private Date paymentDate;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "invoiceID")
    private InvoiceEntity invoiceID;

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public InvoiceEntity getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(InvoiceEntity invoiceID) {
        this.invoiceID = invoiceID;
    }
}
