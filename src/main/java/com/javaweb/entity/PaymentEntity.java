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

    @Column(name = "invoiceID")
    private int invoiceID;
}
