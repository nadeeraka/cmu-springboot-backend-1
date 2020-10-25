package com.nimantha.ABC.API.resources;

import com.nimantha.ABC.API.domain.Test;
import com.nimantha.ABC.API.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/test")

public class TestResource {
    @Autowired
    TestService testService;

    @GetMapping("/{testId}")
    public ResponseEntity<Test> getTestById(HttpServletRequest request, @PathVariable("testId") Integer testId) {
        int userId = (Integer) request.getAttribute("userId");
        Test test = testService.fetchTestById(userId, testId);
        return new ResponseEntity<>(test, HttpStatus.OK);
    }
}
