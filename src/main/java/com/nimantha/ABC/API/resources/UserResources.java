package com.nimantha.ABC.API.resources;

import com.nimantha.ABC.API.Constants;
import com.nimantha.ABC.API.domain.User;
import com.nimantha.ABC.API.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/user")
public class UserResources {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, Object> userMap) {
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.validateUser(email, password);

        return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<Map<String, String>>  register(@RequestBody Map<String, Object> userMap ){
        String firstName = (String) userMap.get("firstName");
        String lastName = (String) userMap.get("lastName");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        Integer age = (Integer) userMap.get("age");
        Boolean is_staff= (Boolean) userMap.get("is_staff");
        User user = userService.registerUser(firstName, lastName, email, password,age,is_staff);
        return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
    }

    private Map<String, String> generateJWTToken(User user) {
        long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
                .claim("userId", user.getUserId())
                .claim("email", user.getEmail())
                .claim("firstName", user.getFirstName())
                .claim("lastName", user.getLastName())
                .claim("age",user.getAge())
                .claim("is_staff",user.isIs_staff())
                .compact();
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }

}
