package com.example.imageconventer.controller;

import com.example.imageconventer.model.dto.UserDto;
import com.example.imageconventer.service.SignupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SignupRestController {
    private final SignupService signupService;
    @PostMapping("/signup")
    public UserDto signupPage(UserDto userDto) {
        log.info("sign up post");
        return signupService.registrationUser(userDto);
    }
}
