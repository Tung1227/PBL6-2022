package com.example.imageconventer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UpLoadController {

    @ResponseBody
    @PostMapping("/upload")
    public String upload(MultipartFile multipartFile, Model model) {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        return "Ok";
    }


    @GetMapping("/upload")
     public String upload(Model model){
        return "converpage";
    }

    @RequestMapping("/")
    public String home(Model model){
        return "redirect:upload";
    }
}
