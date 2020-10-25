package com.nimantha.ABC.API.domain;

import javax.xml.crypto.Data;
import java.util.Date;

public class Appointment {

    private Integer  appointmentId;
    private Integer  userId;
    private Integer  testId;
    private String description;
    private Data appointmentTime;


    public Appointment(Integer appointmentId, Integer userId, Integer testId, String description, Date appointmentTime) {
        this.appointmentId = appointmentId;
        this.userId = userId;
        this.testId = testId;
        this.description = description;
        this.appointmentTime = (Data) appointmentTime;

    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAppointmentTime() {
        return (Date) appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = (Data) appointmentTime;
    }


    }
