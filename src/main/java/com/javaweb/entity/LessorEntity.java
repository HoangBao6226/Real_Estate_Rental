package com.javaweb.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lessor")
public class LessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lessorID;

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

    @OneToMany(mappedBy = "lessorID")
    private List<AccomEntity> listAccom = new ArrayList<AccomEntity>();

    @OneToMany(mappedBy = "lessorID")
    private List<AccountEntity> listAccount = new ArrayList<AccountEntity>();

    public int getLessorID() {
        return lessorID;
    }

    public void setLessorID(int lessorID) {
        this.lessorID = lessorID;
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

    public List<AccomEntity> getListAccom() {
        return listAccom;
    }

    public void setListAccom(List<AccomEntity> listAccom) {
        this.listAccom = listAccom;
    }

    public List<AccountEntity> getListAccount() {
        return listAccount;
    }

    public void setListAccount(List<AccountEntity> listAccount) {
        this.listAccount = listAccount;
    }
}
