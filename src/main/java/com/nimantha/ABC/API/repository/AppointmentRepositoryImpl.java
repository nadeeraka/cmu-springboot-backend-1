package com.nimantha.ABC.API.repository;

import com.nimantha.ABC.API.domain.Appointment;
import com.nimantha.ABC.API.domain.Test;
import com.nimantha.ABC.API.exceptions.BadRequestException;
import com.nimantha.ABC.API.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String SQL_FIND_ALL = "SELECT A.APP_ID,A.TEST_ID, A.USER_ID, A.DESCRIPTION, A.APP_TIME, " +

            "FROM TEST T RIGHT OUTER JOIN APPOINTMENT A ON A.APP_ID = A.APP_ID " +
            "WHERE A.USER_ID = ? GROUP BY T.TEST_ID";
    private static final String SQL_FIND_BY_ID = "SELECT A.APP_ID,A.TEST_ID, A.USER_ID, A.DESCRIPTION, A.APP_TIME, " +
            "FROM APPOINTMENT A RIGHT OUTER JOIN TEST T ON T.TEST_ID = A.TEST_ID " +
            "WHERE T.USER_ID = ? AND A.APP_ID = ? GROUP BY A.APP_ID";
    private static final String SQL_CREATE = "INSERT INTO APPOINTMENT(A.APP_ID,A.TEST_ID, A.USER_ID, A.DESCRIPTION, A.APP_TIME) VALUES(NEXTVAL('TEST_SEQ'), ?, ?, ?,?,?)";
    private static final String SQL_UPDATE = "UPDATE TEST SET IS_URGENT = ?, DESCRIPTION = ? APP_TIME= ?  " +
            "WHERE USER_ID = ? AND TEST_ID = ?";
    private static final String SQL_DELETE_APPOINTMENT = "DELETE FROM APPOINTMENT WHERE USER_ID = ? AND APP_ID = ?";
    private static final String SQL_DELETE_ALL_TEST = "DELETE FROM TEST WHERE APP_ID = ?";

    @Override
    public List<Appointment> fetchAll(Integer userId) {
       // return jdbcTemplate.query(SQL_FIND_ALL, new Object[]{userId}, appRowMapper);
        return null;
    }

    @Override
    public Appointment findById(Integer appId, Integer userId) throws ResourceNotFoundException {
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
    private RowMapper<Appointment> appRowMapper = ((rs, rowNum) -> {
        return new Appointment(rs.getInt("TEST_ID"),
                rs.getInt("USER_ID"),
                rs.getInt("TEST_ID"),
                rs.getString("DESCRIPTION"),
                rs.getDate("APP_TIME"));

    });
}
