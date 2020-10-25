package com.nimantha.ABC.API.resources;

import com.nimantha.ABC.API.domain.Test;
import com.nimantha.ABC.API.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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

    @PostMapping("")
    public ResponseEntity<Test> addTest(HttpServletRequest request,
                                                @RequestBody Map<String, Object> testMap) {
        int userId = (Integer) request.getAttribute("userId");
        Boolean isUrgent = (Boolean) testMap.get("isUrgent");
        String description = (String) testMap.get("description");
        String testResult = (String) testMap.get("testResult");
        Boolean isProgress = (Boolean) testMap.get("isProgress");
        Boolean isFinished = (Boolean) testMap.get("isFinished");
        Test test = testService.addTest(userId,isUrgent, description,testResult,isProgress,isFinished );
        return new ResponseEntity<>(test, HttpStatus.CREATED);
    }
    @GetMapping("/{testId}")
    public ResponseEntity<Test> getTestyById(HttpServletRequest request,
                                                    @PathVariable("testId") Integer testId) {
        int userId = (Integer) request.getAttribute("userId");
        Test test = testService.fetchTestById(testId,userId);
        return new ResponseEntity<>(test, HttpStatus.OK);
    }
}
