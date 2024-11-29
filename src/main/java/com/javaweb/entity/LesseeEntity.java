package com.javaweb.entity;


import jakarta.persistence.*;

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
}
