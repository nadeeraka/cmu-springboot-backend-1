package com.nimantha.ABC.API.repository;

import com.nimantha.ABC.API.domain.User;
import com.nimantha.ABC.API.exceptions.AuthException;

public interface UserRepository {

    Integer create(String firstName, String lastName, String email, String password,Integer age,Boolean is_staff);

    User findByEmailAndPassword(String email, String password) throws AuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);

//    Integer create(String firstName, String lastName, String email, String password, Object age, Object permission);
}