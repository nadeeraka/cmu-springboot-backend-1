package com.nimantha.ABC.API.service;

import com.nimantha.ABC.API.domain.User;
import com.nimantha.ABC.API.exceptions.AuthException;
import com.nimantha.ABC.API.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws AuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null) email = email.toLowerCase();
        if (!pattern.matcher(email).matches())
            throw new AuthException("Invalid email format");
        Integer count = userRepository.getCountByEmail(email);
        if (count > 0)
            throw new AuthException("Email already in use");
        String firstName = null;
        String lastName = null;
        Integer age = null;
        Boolean is_staff = false;
        Integer userId = userRepository.create(firstName, lastName, email, password, age, is_staff);
        return userRepository.findById(userId);
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password, int age, int permission) throws AuthException {
        return null;
    }

}
