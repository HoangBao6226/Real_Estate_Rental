package com.javaweb.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "reservation")
public class ReservationEntity {

    public enum Status {
        In_progress, Completed, Canceled;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationID;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status = Status.In_progress;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
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
