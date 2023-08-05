package com.dansmultipro.athallahrikza.service;

import com.dansmultipro.athallahrikza.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    UserModel findByEmailAndPassword(String email, String password);
    UserModel findByEmail(String email);
}
