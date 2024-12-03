package com.javaweb.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reservation")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationID;

    @ManyToOne
    @JoinColumn(name = "salesID")
    private UserEntity salesID;

    @ManyToOne
    @JoinColumn(name = "lesseeID")
    private LesseeEntity lesseeID;

    @ManyToOne
    @JoinColumn(name = "accommodationID")
    private AccomEntity accommodationID;

    @Column(name = "viewDate")
    private Date viewDate;

    @Column(name = "note")
    private String note;

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public UserEntity getSalesID() {
        return salesID;
    }

    public void setSalesID(UserEntity salesID) {
        this.salesID = salesID;
    }

    public LesseeEntity getLesseeID() {
        return lesseeID;
    }

    public void setLesseeID(LesseeEntity lesseeID) {
        this.lesseeID = lesseeID;
    }

    public AccomEntity getAccommodationID() {
        return accommodationID;
    }

    public void setAccommodationID(AccomEntity accommodationID) {
        this.accommodationID = accommodationID;
    }

    public Date getViewDate() {
        return viewDate;
    }

    public void setViewDate(Date viewDate) {
        this.viewDate = viewDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
