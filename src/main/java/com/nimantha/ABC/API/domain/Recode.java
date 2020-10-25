package com.nimantha.ABC.API.domain;

import javax.xml.crypto.Data;

public class Recode {

    private Integer recodeId;
    private Integer testId;
    private Integer userId;
    private Integer appointmentId;
    private Boolean isUrgent;
    private String  description;
    private String testResultText;
    private Data  recodeCreteAt;

    public Recode(Integer recodeId, Integer testId, Integer userId, Integer appointmentId, Boolean isUrgent, String description, String testResultText, Data recodeCreteAt) {
        this.recodeId = recodeId;
        this.testId = testId;
        this.userId = userId;
        this.appointmentId = appointmentId;
        this.isUrgent = isUrgent;
        this.description = description;
        this.testResultText = testResultText;
        this.recodeCreteAt = recodeCreteAt;
    }

    public Integer getRecodeId() {
        return recodeId;
    }

    public void setRecodeId(Integer recodeId) {
        this.recodeId = recodeId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Boolean getUrgent() {
        return isUrgent;
    }

    public void setUrgent(Boolean urgent) {
        isUrgent = urgent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTestResultText() {
        return testResultText;
    }

    public void setTestResultText(String testResultText) {
        this.testResultText = testResultText;
    }

    public Data getRecodeCreteAt() {
        return recodeCreteAt;
    }

    public void setRecodeCreteAt(Data recodeCreteAt) {
        this.recodeCreteAt = recodeCreteAt;
    }


}
