package com.nimantha.ABC.API.resources;

import com.nimantha.ABC.API.domain.Appointment;
import com.nimantha.ABC.API.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class AppointmentResource {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping("")
    public ResponseEntity<List<Appointment>> getAllAppointments(HttpServletRequest request,
                                                                        @PathVariable("categoryId") Integer appId) {
        int userId = (Integer) request.getAttribute("userId");
        List<Appointment> app = appointmentService.fetchAllTest(userId);
        return new ResponseEntity<>(app, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(HttpServletRequest request,
                                                          @PathVariable("id") Integer appId){
        int userId = (Integer) request.getAttribute("userId");
       Appointment app =appointmentService.appFindById(userId,appId);
        return new ResponseEntity<>(app, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Appointment> addAppointment(HttpServletRequest request,
                                                      @PathVariable("id") Integer userId,
                                                      @RequestBody Map<String, Object> transactionMap) {
        int testId = (Integer) request.getAttribute("testId");
        String description = (String) transactionMap.get("description");
        Date appointment_time = (Date) transactionMap.get("appTime");
       int app = appointmentService.appCreate(userId,testId,description,appointment_time);
        return new ResponseEntity(app, HttpStatus.CREATED);
    }






}
