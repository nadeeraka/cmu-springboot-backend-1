package com.nimantha.ABC.API.repository;

import com.nimantha.ABC.API.domain.Test;
import com.nimantha.ABC.API.exceptions.BadRequestException;
import com.nimantha.ABC.API.exceptions.ResourceNotFoundException;

import java.util.Date;
import java.util.List;

public interface TestRepository {
    List<Test> fetchAllTest(Integer userId);

    Test findById(Integer testId, Integer userId) throws ResourceNotFoundException;

    int create(Integer userId, Boolean isUrgent, String description,
                 String testResult, Boolean isProgress, Boolean isFinished) throws BadRequestException;

    void update(Integer testId, Integer userId, Test UpdatedTest) throws BadRequestException;

    void remove(Integer testId, Integer userId) throws BadRequestException;

}
