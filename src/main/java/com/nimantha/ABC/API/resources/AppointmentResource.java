package com.nimantha.ABC.API.resources;

import com.nimantha.ABC.API.domain.Appointment;
import com.nimantha.ABC.API.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
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
                                                          @PathVariable("id") Integer appId) {
        int userId = (Integer) request.getAttribute("userId");
        Appointment app = appointmentService.appFindById(userId, appId);
        return new ResponseEntity<>(app, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Appointment> addAppointment(HttpServletRequest request,
                                                      @PathVariable("id") Integer userId,
                                                      @RequestBody Map<String, Object> AppMap) {
        int testId = (Integer) request.getAttribute("testId");
        String description = (String) AppMap.get("description");
        Date appointment_time = (Date) AppMap.get("appTime");
        int app = appointmentService.appCreate(userId, testId, description, appointment_time);
        return new ResponseEntity(app, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> updateTransaction(HttpServletRequest request, @PathVariable("userId") Integer appId,
                                                                  @PathVariable("testId") Integer testId,
                                                                  @RequestBody Appointment appointment) {
        int userId = (Integer) request.getAttribute("userId");
        appointmentService.appUpdate(userId, appId, appointment);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @DeleteMapping("/id}")
    public ResponseEntity<Map<String, Boolean>> deleteAppointment(HttpServletRequest request, @PathVariable("id") Integer appId) {
        int userId = (Integer) request.getAttribute("userId");
        appointmentService.appRemove(appId, userId);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


}
