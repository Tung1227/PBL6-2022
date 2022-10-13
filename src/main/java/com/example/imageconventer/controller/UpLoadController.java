package com.example.imageconventer.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UpLoadController {

    private final String PATH = "C:\\Tung\\nam4\\pbl6\\repo\\python\\image\\";

    @ResponseBody
    @PostMapping("/upload")
    public String upload(@RequestParam(value="file") MultipartFile file, Model model) throws IOException, JSONException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String filePath = PATH + StringUtils.cleanPath(file.getOriginalFilename());
        file.transferTo(new File(filePath));
        JSONObject result = new JSONObject();
        result.put("status", "OK");
        result.put("name",fileName );
         return result.toString();
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
