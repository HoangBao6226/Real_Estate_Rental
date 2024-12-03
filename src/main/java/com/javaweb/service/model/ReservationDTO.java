package com.javaweb.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public class ReservationDTO {

//    private int accomID;
//    private int lesseeID;
    private Date viewDate;
    private LocalTime viewTime;
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

    public LocalTime getViewTime() {
        return viewTime;
    }

    public void setViewTime(LocalTime viewTime) {
        this.viewTime = viewTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
