package com.nimantha.ABC.API.service;

import com.nimantha.ABC.API.domain.User;
import com.nimantha.ABC.API.exceptions.AuthException;


public interface UserService {

    User validateUser(String email, String password) throws AuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws AuthException;

}