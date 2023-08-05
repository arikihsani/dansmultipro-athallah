package com.dansmultipro.athallahrikza.repository;

import com.dansmultipro.athallahrikza.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDb extends JpaRepository<UserModel, Long> {
    UserModel findByEmailAndPassword(String email, String password);
    UserModel findByEmail(String email);
}
