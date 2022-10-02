package com.example.imageconventer.service;

import com.example.imageconventer.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface LoginService extends JpaRepository<User, Long> {

}

