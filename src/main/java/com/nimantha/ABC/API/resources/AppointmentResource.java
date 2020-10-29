package com.nimantha.ABC.API.resources;

import com.nimantha.ABC.API.domain.Appointment;
import com.nimantha.ABC.API.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AppointmentResource {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping("")
    public ResponseEntity<List<Appointment>> getAllTransactions(HttpServletRequest request,
                                                                        @PathVariable("categoryId") Integer appId) {
        int userId = (Integer) request.getAttribute("userId");
        List<Appointment> app = appointmentService.fetchAllTest(userId);
        return new ResponseEntity<>(app, HttpStatus.OK);
    }



}
