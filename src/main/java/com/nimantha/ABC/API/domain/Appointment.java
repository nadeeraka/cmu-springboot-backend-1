package com.nimantha.ABC.API.domain;

import javax.xml.crypto.Data;
import java.util.Date;

public class Appointment {

    private Integer  appId;
    private Integer  userId;
    private Integer  testId;
    private String description;
    private Data appTime;


    public Appointment(Integer appId, Integer userId, Integer testId, String description, Date appTime) {
        this.appId = appId;
        this.userId = userId;
        this.testId = testId;
        this.description = description;
        this.appTime = (Data) appTime;

    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appointmentId) {
        this.appId = appId;
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

    public Date getAppTime() {
        return (Date) appTime;
    }

    public void setAppTime(Date appointmentTime) {
        this.appTime = (Data) appointmentTime;
    }


    }
