package com.nimantha.ABC.API.resources;

import com.nimantha.ABC.API.domain.User;
import com.nimantha.ABC.API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/user")
public class UserResources {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>>  register(@RequestBody Map<String, Object> userMap ){
        String firstName = (String) userMap.get("firstName");
        String lastName = (String) userMap.get("lastName");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        int age = (Integer) userMap.get("age");
        int permission= (Integer) userMap.get("permission");
        User user = userService.registerUser(firstName, lastName, email, password,age,permission);
        Map<String, String> map = new HashMap<>();
        map.put("massage","created");
//        User user = userService.validateUser(email, password);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
