package com.example.imageconventer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class successController {

    @GetMapping("/success")
    public String success(Model model) {
        return "successpage";
    }
}
