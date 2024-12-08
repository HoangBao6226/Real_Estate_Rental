package com.javaweb.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
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
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private LocalDateTime endDate;

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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
