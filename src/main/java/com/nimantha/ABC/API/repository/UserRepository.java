package com.nimantha.ABC.API.repository;

import com.nimantha.ABC.API.domain.User;
import com.nimantha.ABC.API.exceptions.AuthException;

public interface UserRepository {

    int createUser(String firstName,String lastName,String email, String password,int age, int permission) throws AuthException;

    int findByEmail (String email) throws AuthException;

    User findByEmailAndPassword(String email, String password) throws AuthException;

    int findById(int id) throws AuthException;




}
