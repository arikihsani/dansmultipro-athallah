package com.dansmultipro.athallahrikza.service;

import com.dansmultipro.athallahrikza.model.UserModel;
import com.dansmultipro.athallahrikza.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user){
        for (UserModel x: userDb.findAll()){
            // check if there is duplicate email
            if (x.getEmail().equals(user.getEmail())){
                return null;
            }
        }
        // encrypt the password
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public UserModel findByEmailAndPassword(String email, String password){
        return userDb.findByEmailAndPassword(email, password);
    }

    @Override
    public UserModel findByEmail(String email){
        return userDb.findByEmail(email);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }
}
