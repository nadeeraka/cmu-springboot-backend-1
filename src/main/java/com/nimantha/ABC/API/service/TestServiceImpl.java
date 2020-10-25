package com.nimantha.ABC.API.service;

import com.nimantha.ABC.API.domain.Test;
import com.nimantha.ABC.API.exceptions.BadRequestException;
import com.nimantha.ABC.API.exceptions.ResourceNotFoundException;
import com.nimantha.ABC.API.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional

public class TestServiceImpl  implements  TestService{
    @Autowired
    TestRepository testRepository;

    @Override
    public List<Test> fetchAllTest(Integer userId) {
       return testRepository.fetchAllTest(userId);
    }

    @Override
    public Test fetchTestById(Integer testId, Integer userId) throws ResourceNotFoundException {
        return testRepository.findById(testId,userId);
    }

    @Override
    public Test addTest(Integer userId, Boolean isUrgent, String description, String testResult, Boolean isProgress, Boolean isFinished) throws BadRequestException {
        Integer testId = testRepository.create(userId,  isUrgent, description,testResult,isProgress, isFinished);
        return testRepository.findById(userId,testId);
    }

    @Override
    public void updateTest(Integer testId, Integer userId, Test UpdatedTest) throws BadRequestException {

    }

    @Override
    public void removeTestWithCascade(Integer testId, Integer userId) throws BadRequestException {

    }
}
