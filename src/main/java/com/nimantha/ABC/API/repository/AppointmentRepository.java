package com.nimantha.ABC.API.repository;

import com.nimantha.ABC.API.domain.Appointment;
import com.nimantha.ABC.API.exceptions.BadRequestException;
import com.nimantha.ABC.API.exceptions.ResourceNotFoundException;

import javax.xml.crypto.Data;
import java.util.List;

public interface AppointmentRepository {
    List<Appointment> fetchAll(Integer userId);

    Appointment findById(Integer appId, Integer userId) throws ResourceNotFoundException;

    int create(Integer userId,Integer testId,String description, Data appointmentTime)throws BadRequestException;

    void update(Integer appId, Integer userId, Appointment UpdatedTest) throws BadRequestException;

    void remove(Integer appId, Integer userId) throws BadRequestException;

}
