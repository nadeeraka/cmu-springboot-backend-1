package com.nimantha.ABC.API.service;

import com.nimantha.ABC.API.domain.Appointment;
import com.nimantha.ABC.API.domain.Test;
import com.nimantha.ABC.API.exceptions.BadRequestException;
import com.nimantha.ABC.API.exceptions.ResourceNotFoundException;

import javax.xml.crypto.Data;
import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {
    @Override
    public List<Appointment> fetchAllTest(Integer userId) {
        return null;
    }

    @Override
    public Appointment appFindById(Integer appId, Integer userId) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public int appCreate(Integer userId, Integer testId, String description, Data appointmentTime) throws BadRequestException {
        return 0;
    }

    @Override
    public void appUpdate(Integer appId, Integer userId, Test UpdatedTest) throws BadRequestException {

    }

    @Override
    public void appRemove(Integer appId, Integer userId) throws BadRequestException {

    }
}
