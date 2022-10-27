package com.example.imageconventer.service;

import com.example.imageconventer.model.entity.User;
import com.example.imageconventer.repository.SignupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class SignupService {
    private final SignupRepository signupRepository;

    public User registrationUser(User user) {
        user.setId(String.valueOf(UUID.randomUUID()));
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        log.info("service");
        return signupRepository.save(user);

    }


}
