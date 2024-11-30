package com.javaweb.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "statusID")
    private List<DetailStatusEntity> listStatus = new ArrayList<DetailStatusEntity>();

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DetailStatusEntity> getListStatus() {
        return listStatus;
    }

    public void setListStatus(List<DetailStatusEntity> listStatus) {
        this.listStatus = listStatus;
    }
}
