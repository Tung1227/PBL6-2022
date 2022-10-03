package com.example.imageconventer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class upLoadController {
    @RequestMapping("/upload")
     public String upload(Model model){
        return "converpage";
    }
}
