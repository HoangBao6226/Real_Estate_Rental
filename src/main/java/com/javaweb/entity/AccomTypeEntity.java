package com.javaweb.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accomtype")
public class AccomTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accomTypeID;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "accomTypeID")
    private List<AccomEntity> listAccom = new ArrayList<AccomEntity>();

    @OneToMany(mappedBy = "accomTypeID")
    private List<AdvantageEntity> listAdvan = new ArrayList<AdvantageEntity>();

    public int getAccomTypeID() {
        return accomTypeID;
    }

    public void setAccomTypeID(int accomTypeID) {
        this.accomTypeID = accomTypeID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AccomEntity> getListAccom() {
        return listAccom;
    }

    public void setListAccom(List<AccomEntity> listAccom) {
        this.listAccom = listAccom;
    }

    public List<AdvantageEntity> getListAdvan() {
        return listAdvan;
    }

    public void setListAdvan(List<AdvantageEntity> listAdvan) {
        this.listAdvan = listAdvan;
    }
}
