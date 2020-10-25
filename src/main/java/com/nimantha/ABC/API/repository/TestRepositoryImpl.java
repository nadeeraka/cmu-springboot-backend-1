package com.nimantha.ABC.API.repository;

import com.nimantha.ABC.API.domain.Test;
import com.nimantha.ABC.API.exceptions.BadRequestException;
import com.nimantha.ABC.API.exceptions.ResourceNotFoundException;

import java.util.Date;
import java.util.List;

public class TestRepositoryImpl implements  TestRepository {

    @Override
    public List<Test> fetchAllTest(Integer userId) {
        return null;
    }

    @Override
    public Test findById(Integer testId, Integer userId) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Test create(Integer userId, Boolean isUrgent, String description, String testResult, Boolean isProgress, Boolean isFinished, Date TestCreatedTime) throws BadRequestException {
        return null;
    }

    @Override
    public void update(Integer testId, Integer userId, Test UpdatedTest) throws BadRequestException {

    }

    @Override
    public void remove(Integer testId, Integer userId) throws BadRequestException {

    }
}
