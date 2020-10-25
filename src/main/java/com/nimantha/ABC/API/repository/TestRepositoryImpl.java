package com.nimantha.ABC.API.repository;

import com.nimantha.ABC.API.domain.Test;
import com.nimantha.ABC.API.exceptions.BadRequestException;
import com.nimantha.ABC.API.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class TestRepositoryImpl implements  TestRepository {

    private static final String SQL_FIND_ALL = "SELECT T.TEST_ID, T.USER_ID, T.IS_URGENT, T.DESCRIPTION, T.TEST_RESULT, T.IS_PROGRESS,T.IS_FINISHED, T.TEST_CREATED_TIME" +

            "FROM APPOINTMENT A RIGHT OUTER JOIN TEST T ON T.TEST_ID = A.TEST_ID " +
            "WHERE T.USER_ID = ? GROUP BY A.TEST_ID";
    private static final String SQL_FIND_BY_ID = "SELECT T.TEST_ID, T.USER_ID, T.IS_URGENT, T.DESCRIPTION, T.TEST_RESULT, T.IS_PROGRESS,T.IS_FINISHED, T.TEST_CREATED_TIME, " +
            "FROM APPOINTMENT A RIGHT OUTER JOIN TEST T ON T.TEST_ID = A.TEST_ID "  +
            "WHERE T.USER_ID = ? AND T.TEST_ID = ? GROUP BY T.TEST_ID";
    private static final String SQL_CREATE = "INSERT INTO TEST(T.TEST_ID, T.USER_ID, T.IS_URGENT, T.DESCRIPTION, T.TEST_RESULT, T.IS_PROGRESS,T.IS_FINISHED, T.TEST_CREATED) VALUES(NEXTVAL('TEST_SEQ'), ?, ?, ?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE TEST SET IS_URGENT = ?, DESCRIPTION = ? TEST_RESULT= ?  IS_PROGRESS= ?  IS_FINISHED =? TEST_CREATED_TIME=?" +
            "WHERE USER_ID = ? AND TEST_ID = ?";
    private static final String SQL_DELETE_CATEGORY = "DELETE FROM TEST WHERE USER_ID = ? AND TEST_ID = ?";
    private static final String SQL_DELETE_ALL_TRANSACTIONS = "DELETE FROM APPOINTMENT WHERE TEST_ID = ?";

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
