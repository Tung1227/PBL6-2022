package com.example.imageconventer.controller;

import com.example.imageconventer.model.dto.LoginUser;
import com.example.imageconventer.model.entity.User;
import com.example.imageconventer.service.EncodeService;
import com.example.imageconventer.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    @Autowired
    LoginService loginService;

    @Autowired
    LoginUser loginUser;

    @Autowired
    EncodeService encodeService;

    @GetMapping("/login")
    public String loginPage() {
        log.info("login page");
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model){
        User u = loginService.findUserByUserName(username);
        String encodedPassword = encodeService.encode(password);
        if (u == null || !encodeService.match(password,u.getPassword())) {
            model.addAttribute("errorMsg", "Sai tài khoản hoặc mật khẩu");
            return "login";
        }
        loginUser.setUsername(username);
        return "redirect:upload";
    }
//    @PostMapping("/signup")
//    public String signup(){
//        User u = new User();
//          u.setUserName("tungl");
//          u.setPassword("123");
//          loginService.save(u);
//        return "successpage";
//    }
}
