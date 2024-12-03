package com.javaweb.service.model;

import java.util.Date;

public class ReservationDTO {

//    private int accomID;
//    private int lesseeID;
    private Date viewDate;
    private String note;

//    public int getAccomID() {
//        return accomID;
//    }
//
//    public void setAccomID(int accomID) {
//        this.accomID = accomID;
//    }
//
//    public int getLesseeID() {
//        return lesseeID;
//    }
//
//    public void setLesseeID(int lesseeID) {
//        this.lesseeID = lesseeID;
//    }

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
