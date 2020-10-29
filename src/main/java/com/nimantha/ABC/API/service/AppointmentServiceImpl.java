package com.nimantha.ABC.API.service;

import com.nimantha.ABC.API.domain.Appointment;
import com.nimantha.ABC.API.domain.Test;
import com.nimantha.ABC.API.exceptions.BadRequestException;
import com.nimantha.ABC.API.exceptions.ResourceNotFoundException;
import com.nimantha.ABC.API.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.util.List;

@Service
@Transactional

public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;
    @Override
    public List<Appointment> fetchAllTest(Integer userId) {
        return null;
    }

    @Override
    public Appointment appFindById(Integer appId, Integer userId) throws ResourceNotFoundException {
        return appointmentRepository.findById(appId, userId);
    }

    @Override
    public int appCreate(Integer userId, Integer testId, String description, Data appointmentTime) throws BadRequestException {
        int appId = appointmentRepository.create(userId, testId, description, appointmentTime);
        return appId;
    }

    @Override
    public void appUpdate(Integer appId, Integer userId, Test UpdatedTest) throws BadRequestException {

    }

    @Override
    public void appRemove(Integer appId, Integer userId) throws BadRequestException {

    }
}
