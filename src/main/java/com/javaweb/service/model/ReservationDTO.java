package com.javaweb.service.model;

import java.util.Date;

public class ReservationDTO {

    private Date viewDate;
    private String note;

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
