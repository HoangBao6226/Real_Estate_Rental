package com.javaweb.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleID;

    @Column(name = "roleName", nullable = false)
    private String roleName;

    @Column(name = "description", nullable = false)
    private String description;
}
