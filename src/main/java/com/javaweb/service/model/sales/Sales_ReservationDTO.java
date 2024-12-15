package com.javaweb.service.model.sales;

import com.javaweb.entity.AccomEntity;
import com.javaweb.entity.LesseeEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Date;

public class Sales_ReservationDTO {

    public enum Status {
        In_progress, Completed, Canceled;
    }

    private int reservationID;
    private Date viewDate;
    private String note;

    @Enumerated(EnumType.STRING)
    private Status status = Status.In_progress;

    private LesseeEntity lessee;
    private AccomEntity accom;

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LesseeEntity getLessee() {
        return lessee;
    }

    public void setLessee(LesseeEntity lessee) {
        this.lessee = lessee;
    }

    public AccomEntity getAccom() {
        return accom;
    }

    public void setAccom(AccomEntity accom) {
        this.accom = accom;
    }
}
