package com.example.imageconventer.service;

import com.example.imageconventer.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface loginService extends JpaRepository<User, Long> {

}

