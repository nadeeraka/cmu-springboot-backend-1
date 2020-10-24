package com.nimantha.ABC.API.resources;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/user")
public class UserResources {

    @PostMapping("/register")
    public String register(@RequestBody Map<String, Object> userMap ){
        String firstName = (String) userMap.get("firstName");
        String lastName = (String) userMap.get("lastName");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        int age = (Integer) userMap.get("age");
        int permission= (Integer) userMap.get("permission");
        return firstName + " "+ lastName+" "+email+" "+age + " "+ permission;

//        User user = userService.validateUser(email, password);
//        return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
    }

}
