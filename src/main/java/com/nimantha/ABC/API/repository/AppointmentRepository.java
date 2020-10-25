package com.nimantha.ABC.API.repository;

import com.nimantha.ABC.API.domain.Test;
import com.nimantha.ABC.API.exceptions.BadRequestException;
import com.nimantha.ABC.API.exceptions.ResourceNotFoundException;

import javax.xml.crypto.Data;
import java.util.List;

public interface AppointmentRepository {
    List<Test> fetchAllTest(Integer userId);

    Test findById(Integer appId, Integer userId) throws ResourceNotFoundException;

    int create(Integer userId,Integer testId,String description, Data appointmentTime)throws BadRequestException;

    void update(Integer appId, Integer userId, Test UpdatedTest) throws BadRequestException;

    void remove(Integer appId, Integer userId) throws BadRequestException;

}
