package com.example.imageconventer.controller;

import com.example.imageconventer.model.entity.User;
import com.example.imageconventer.service.SignupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SignupController {
//    private static SignupService signupService;
    @Autowired
    SignupService signupService;

    @GetMapping("/signup")
    public String signupPage() {
        log.info("sign up page");
        return "signup";
    }

    @PostMapping("/signup")
    public User signupPage(User user) {
        log.info("sign up prepossessing");
        return signupService.registrationUser(user);
    }
}
