package com.example.imageconventer.Controller;

import com.example.imageconventer.model.dto.Login;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    @GetMapping("/login")
    public String loginPage() {
        log.info("login page");
        return "login";

