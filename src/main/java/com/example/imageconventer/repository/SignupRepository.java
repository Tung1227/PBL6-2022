package com.example.imageconventer.repository;

import com.example.imageconventer.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SignupRepository extends JpaRepository<User, UUID> {
    @Query("select u from User u where u.userName = ?1 or u.email = ?2")
    List<User> findUserByUserName(String userName, String email);
}
