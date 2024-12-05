package com.javaweb.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lessee")
public class LesseeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lesseeID;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "firstName", nullable = false)
    private String firstName;

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

    @OneToMany(mappedBy = "lesseeID")
    private List<AccountEntity> listAccount = new ArrayList<AccountEntity>();

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

    public List<AccountEntity> getListAccount() {
        return listAccount;
    }

    public void setListAccount(List<AccountEntity> listAccount) {
        this.listAccount = listAccount;
    }
}
