package com.nimantha.ABC.API.domain;

import javax.xml.crypto.Data;

public class Payments {

    private Integer paymentId;
    private Integer testId;
    private Integer userId;
    private Boolean isPayed;
    private Double amount;
    private Data paymentCreatedTime;

    public Payments(Integer paymentId, Integer testId, Integer userId, Boolean isPayed, Double amount, Data paymentCreatedTime) {
        this.paymentId = paymentId;
        this.testId = testId;
        this.userId = userId;
        this.isPayed = isPayed;
        this.amount = amount;
        this.paymentCreatedTime = paymentCreatedTime;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
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

    public Boolean getPayed() {
        return isPayed;
    }

    public void setPayed(Boolean payed) {
        isPayed = payed;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Data getPaymentCreatedTime() {
        return paymentCreatedTime;
    }

    public void setPaymentCreatedTime(Data paymentCreatedTime) {
        this.paymentCreatedTime = paymentCreatedTime;
    }
}
