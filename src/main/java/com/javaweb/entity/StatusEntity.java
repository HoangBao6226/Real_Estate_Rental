package com.javaweb.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "status")
public class StatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusID;

    @Column(name = "status")
    private String status;

    @Column(name = "description")
    private String description;
}
