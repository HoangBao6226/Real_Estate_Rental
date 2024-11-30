package com.javaweb.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "detailstatus")
public class DetailStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailStatusID;

    @ManyToOne
    @JoinColumn(name = "accommodationID", unique = true)
    private AccomEntity accommodationID;

    @ManyToOne
    @JoinColumn(name = "statusID")
    private StatusEntity statusID;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "reason")
    private String reason;

    public int getDetailStatusID() {
        return detailStatusID;
    }

    public void setDetailStatusID(int detailStatusID) {
        this.detailStatusID = detailStatusID;
    }

    public AccomEntity getAccommodationID() {
        return accommodationID;
    }

    public void setAccommodationID(AccomEntity accommodationID) {
        this.accommodationID = accommodationID;
    }

    public StatusEntity getStatusID() {
        return statusID;
    }

    public void setStatusID(StatusEntity statusID) {
        this.statusID = statusID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
