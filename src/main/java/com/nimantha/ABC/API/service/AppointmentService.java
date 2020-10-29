package com.nimantha.ABC.API.service;

import com.nimantha.ABC.API.domain.Appointment;
import com.nimantha.ABC.API.domain.Test;
import com.nimantha.ABC.API.exceptions.BadRequestException;
import com.nimantha.ABC.API.exceptions.ResourceNotFoundException;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface AppointmentService {
    List<Appointment> fetchAllTest(Integer userId);

    Appointment appFindById(Integer appId, Integer userId) throws ResourceNotFoundException;

    int appCreate(Integer userId,Integer testId,String description, Date appointmentTime)throws BadRequestException;

    void appUpdate(Integer appId, Integer userId, Test UpdatedTest) throws BadRequestException;

    void appRemove(Integer appId, Integer userId) throws BadRequestException;
}
