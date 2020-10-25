package com.nimantha.ABC.API.service;

import com.nimantha.ABC.API.domain.Test;
import com.nimantha.ABC.API.exceptions.BadRequestException;
import com.nimantha.ABC.API.exceptions.ResourceNotFoundException;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Date;
import java.util.List;

public interface TestService {

    List<Test> fetchAllTest(Integer userId);

    Test fetchTestById(Integer testId, Integer userId) throws ResourceNotFoundException;

    Test addTest(Integer userId, Boolean isUrgent, String description,
                 String testResult, Boolean isProgress, Boolean isFinished, Date TestCreatedTime) throws BadRequestException;

    void updateTest(Integer testId, Integer userId, Test UpdatedTest) throws BadRequestException;

    void removeTestWithCascade(Integer testId, Integer userId) throws BadRequestException;



}
