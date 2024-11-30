package com.javaweb.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "advantage")
public class AdvantageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int advantageID;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "accomTypeID")
    private AccomTypeEntity accomTypeID;

    public int getAdvantageID() {
        return advantageID;
    }

    public void setAdvantageID(int advantageID) {
        this.advantageID = advantageID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccomTypeEntity getAccomTypeID() {
        return accomTypeID;
    }

    public void setAccomTypeID(AccomTypeEntity accomTypeID) {
        this.accomTypeID = accomTypeID;
    }
}
