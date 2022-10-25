package com.example.imageconventer.repository;

import com.example.imageconventer.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SignupRepository extends JpaRepository<User, UUID> {

}
