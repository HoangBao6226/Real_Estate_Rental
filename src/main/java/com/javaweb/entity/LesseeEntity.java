package com.javaweb.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
public class LesseeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lesseeID;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "identityNumber", unique = true)
    private String identityNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "lesseeID")
    private List<ReservationEntity> listReserve = new ArrayList<ReservationEntity>();

    @OneToMany(mappedBy = "lesseeID")
    private List<InvoiceEntity> listInvoice = new ArrayList<InvoiceEntity>();

    public int getLesseeID() {
        return lesseeID;
    }

    public void setLesseeID(int lesseeID) {
        this.lesseeID = lesseeID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ReservationEntity> getListReserve() {
        return listReserve;
    }

    public void setListReserve(List<ReservationEntity> listReserve) {
        this.listReserve = listReserve;
    }

    public List<InvoiceEntity> getListInvoice() {
        return listInvoice;
    }

    public void setListInvoice(List<InvoiceEntity> listInvoice) {
        this.listInvoice = listInvoice;
    }
}
