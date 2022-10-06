package com.example.imageconventer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class upLoadController {
    @GetMapping("/upload")
     public String upload(Model model){
        return "converpage";
    }

    @RequestMapping("/")
    public String home(Model model){
        return "redirect:upload";
    }
}
