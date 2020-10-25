package com.nimantha.ABC.API.repository;

import com.nimantha.ABC.API.domain.Test;
import com.nimantha.ABC.API.exceptions.BadRequestException;
import com.nimantha.ABC.API.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class TestRepositoryImpl implements TestRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    private static final String SQL_FIND_ALL = "SELECT T.TEST_ID, T.USER_ID, T.IS_URGENT, T.DESCRIPTION, T.TEST_RESULT, T.IS_PROGRESS,T.IS_FINISHED," +

            "FROM APPOINTMENT A RIGHT OUTER JOIN TEST T ON T.TEST_ID = A.TEST_ID " +
            "WHERE T.USER_ID = ? GROUP BY A.TEST_ID";
    private static final String SQL_FIND_BY_ID = "SELECT T.TEST_ID, T.USER_ID, T.IS_URGENT, T.DESCRIPTION, T.TEST_RESULT, T.IS_PROGRESS,T.IS_FINISHED, " +
            "FROM APPOINTMENT A RIGHT OUTER JOIN TEST T ON T.TEST_ID = A.TEST_ID " +
            "WHERE T.USER_ID = ? AND T.TEST_ID = ? GROUP BY T.TEST_ID";
    private static final String SQL_CREATE = "INSERT INTO TEST(T.TEST_ID, T.USER_ID, T.IS_URGENT, T.DESCRIPTION, T.TEST_RESULT, T.IS_PROGRESS,T.IS_FINISHED) VALUES(NEXTVAL('TEST_SEQ'), ?, ?, ?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE TEST SET IS_URGENT = ?, DESCRIPTION = ? TEST_RESULT= ?  IS_PROGRESS= ?  IS_FINISHED =? TEST_CREATED_TIME=?" +
            "WHERE USER_ID = ? AND TEST_ID = ?";
    private static final String SQL_DELETE_TEST = "DELETE FROM TEST WHERE USER_ID = ? AND TEST_ID = ?";
    private static final String SQL_DELETE_ALL_APPOINTMENT = "DELETE FROM APPOINTMENT WHERE TEST_ID = ?";

    @Override
    public List<Test> fetchAllTest(Integer userId) {
        return jdbcTemplate.query(SQL_FIND_ALL, new Object[]{userId}, testRowMapper);
    }

    @Override
    public Test findById(Integer testId, Integer userId) throws ResourceNotFoundException {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{userId, testId}, testRowMapper);
        } catch (Exception e) {
            throw new ResourceNotFoundException("details not found");
        }
    }

    @Override
    public int create(Integer userId, Boolean isUrgent, String description, String testResult, Boolean isProgress, Boolean isFinished) throws BadRequestException {

        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, userId);
                ps.setBoolean(2, isUrgent);
                ps.setString(3, description);
                ps.setString(4, testResult);
                ps.setBoolean(5, isProgress);
                ps.setBoolean(6, isFinished);

                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("TEST_ID");
        } catch (Exception e) {
            throw new BadRequestException("Invalid request");
        }
    }

    @Override
    public void update(Integer testId, Integer userId, Test UpdatedTest) throws BadRequestException {
        try {
            jdbcTemplate.update(SQL_UPDATE, UpdatedTest.getUrgent(), UpdatedTest.getDescription(),UpdatedTest.getTestResult(),UpdatedTest.getFinished(),UpdatedTest.getProgress() ,userId, testId);
        }catch (Exception e) {
            throw new BadRequestException("Invalid request");
        }
    }

    @Override
    public void remove(Integer testId, Integer userId) throws BadRequestException {
        this.remove(testId,userId);
       jdbcTemplate.update(SQL_DELETE_TEST, new Object[]{userId, testId});
    }

    private RowMapper<Test> testRowMapper = ((rs, rowNum) -> {
        return new Test(rs.getInt("TEST_ID"),
                rs.getInt("USER_ID"),
                rs.getBoolean("IS_URGENT"),
                rs.getString("DESCRIPTION"),
                rs.getString("TEST_RESULT"),
                rs.getBoolean("IS_PROGRESS"),
                rs.getBoolean("IS_FINISHED"));
    });
}
