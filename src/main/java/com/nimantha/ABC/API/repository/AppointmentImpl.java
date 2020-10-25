package com.nimantha.ABC.API.repository;

import com.nimantha.ABC.API.domain.Test;
import com.nimantha.ABC.API.exceptions.BadRequestException;
import com.nimantha.ABC.API.exceptions.ResourceNotFoundException;

import javax.xml.crypto.Data;
import java.util.List;

public class AppointmentImpl implements AppointmentRepository {
    @Override
    public List<Test> fetchAllTest(Integer userId) {
        return null;
    }

    @Override
    public Test findById(Integer appId, Integer userId) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public int create(Integer userId, Integer testId, String description, Data appointmentTime) throws BadRequestException {
        return 0;
    }

    @Override
    public void update(Integer appId, Integer userId, Test UpdatedTest) throws BadRequestException {

    }

    @Override
    public void remove(Integer appId, Integer userId) throws BadRequestException {

    }
}
