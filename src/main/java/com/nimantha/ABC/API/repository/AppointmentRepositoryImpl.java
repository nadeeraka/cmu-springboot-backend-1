package com.nimantha.ABC.API.repository;

import com.nimantha.ABC.API.domain.Appointment;
import com.nimantha.ABC.API.exceptions.BadRequestException;
import com.nimantha.ABC.API.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    Calendar calendar = Calendar.getInstance();

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
        return jdbcTemplate.query(SQL_FIND_ALL, new Object[]{userId}, appRowMapper);

    }

    @Override
    public Appointment findById(Integer appId, Integer userId) throws ResourceNotFoundException {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{userId, appId},appRowMapper);
        }catch (Exception e) {
            throw new ResourceNotFoundException("Appointment not found");
        }
    }

    @Override
    public int create(Integer userId, Integer testId, String description, Data appointmentTime) throws BadRequestException {

        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, testId);
                ps.setInt(2, userId);
                ps.setString(3, description);
                ps.setTimestamp(4, new Timestamp(calendar.getTimeInMillis()));
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("APP_ID");
        }catch (Exception e) {
            throw new BadRequestException("Invalid request");
        }
    }

    @Override
    public void update(Integer appId, Integer userId, Appointment appointment) throws BadRequestException {
        try {
            jdbcTemplate.update(SQL_UPDATE, appointment.getDescription(), appointment.getTestId(),appId,userId);
        }catch (Exception e) {
            throw new BadRequestException("Invalid request");
        }
    }

    @Override
    public void remove(Integer appId, Integer userId) throws BadRequestException {
        int count = jdbcTemplate.update(SQL_DELETE_APPOINTMENT, userId, appId);
        if(count == 0)
            throw new ResourceNotFoundException(" not found");
    }
    private RowMapper<Appointment> appRowMapper = ((rs, rowNum) -> {
        return new Appointment(rs.getInt("TEST_ID"),
                rs.getInt("USER_ID"),
                rs.getInt("TEST_ID"),
                rs.getString("DESCRIPTION"),
                rs.getDate("APP_TIME"));

    });
}
