package com.nimantha.ABC.API.domain;

import java.util.Date;

public class Test {

    private  Integer id;
    private Integer userId;
    private Boolean isUrgent;
    private String description;
    private String testResult;
    private Boolean isProgress;
    private Boolean isFinished;
    private Date TestCreatedTime;

    public Test(Integer id, Integer userId, Boolean isUrgent, String description, String testResult, Boolean isProgress, Boolean isFinished, Date testCreatedTime) {
        this.id = id;
        this.userId = userId;
        this.isUrgent = isUrgent;
        this.description = description;
        this.testResult = testResult;
        this.isProgress = isProgress;
        this.isFinished = isFinished;
        TestCreatedTime = testCreatedTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public Boolean getProgress() {
        return isProgress;
    }

    public void setProgress(Boolean progress) {
        isProgress = progress;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public Date getTestCreatedTime() {
        return TestCreatedTime;
    }

    public void setTestCreatedTime(Date testCreatedTime) {
        TestCreatedTime = testCreatedTime;
    }
}
