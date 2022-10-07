package com.example.imageconventer.service;

import com.example.imageconventer.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginService extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u where u.userName = ?1")
    User findByUserName(String username);
}

