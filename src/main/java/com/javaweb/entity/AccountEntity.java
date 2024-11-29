package com.javaweb.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountID;

    @Column(name = "username",unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "isActive")
    private boolean isActive = true;

    @Column(name = "roleID")
    private int roleID;

    @Column(name = "userID")
    private int userID;
}
