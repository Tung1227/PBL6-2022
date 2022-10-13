package com.example.imageconventer.controller;

import com.example.imageconventer.model.dto.LoginUser;
import com.example.imageconventer.model.entity.Image;
import com.example.imageconventer.model.entity.User;
import com.example.imageconventer.service.UploadFileService;
import com.example.imageconventer.service.UploadFileServiceImpl;
import com.example.imageconventer.service.UploadService;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class UpLoadController {


    @Autowired()
    UploadFileService uploadFileService;

    @Autowired
    UploadService uploadService;

    @Autowired
    LoginUser loginUser;



    @ResponseBody
    @PostMapping("upload")
    public String upload(@RequestParam(value="files") MultipartFile file) throws JSONException {
        String fileName = file.getOriginalFilename();
        JSONObject result = new JSONObject();
        if(uploadFileService.upLoad(file).equals("OK")){
            result.put("status", "OK");
            result.put("name",fileName);
            Image img = new Image();
            img.setImageFile(fileName);
            img.setStatus(false);
            User u = new User();
            u.setUserName(loginUser.getUsername());
            img.setUser(u);
            uploadService.save(img);
        }else{
            result.put("status", "FAIL");
        }
         return result.toString();
    }


    @GetMapping("upload")
     public String upload(Model model){
        return "converpage";
    }

    @RequestMapping("/")
    public String home(Model model){
        return "redirect:upload";
    }
}
