package com.example.imageconventer.service;

import com.example.imageconventer.Message.Message;
import com.example.imageconventer.model.dto.UserDto;
import com.example.imageconventer.model.entity.User;
import com.example.imageconventer.repository.SignupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class SignupService {
    private final SignupRepository signupRepository;
    private static final String EMPTY = "";

    private boolean checkInsertFlag = true;


    public UserDto registrationUser(UserDto user) {
        User userData = new User();
        List<User> listUsers = signupRepository.findUserByUserName(user.getUserName(), user.getEmail());
        user.setError("");
        listUsers.forEach(userDB -> {
            if (user.getUserName().equals(userDB.getUserName())) {
                checkInsertFlag = false;
                userData.setUserName(EMPTY);
                user.setError(Message.USERNAME_CHECK);
            } else if (user.getEmail().equals(userDB.getEmail())) {
                checkInsertFlag = false;
                userData.setEmail(EMPTY);
                user.setError(Message.EMAIL_CHECK);
            }
        });
        userData.setId(String.valueOf(UUID.randomUUID()));
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        userData.setPassword(encodedPassword);
        userData.setUserName(user.getUserName());
        userData.setEmail(user.getEmail());
        if (checkInsertFlag || listUsers.size() == 0) {
            signupRepository.save(userData);
        }
        return user;
    }


}
