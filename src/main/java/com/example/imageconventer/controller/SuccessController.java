package com.example.imageconventer.controller;

import com.example.imageconventer.model.dto.LoginUser;
import com.example.imageconventer.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("convert")
public class SuccessController {

    @Autowired
    LoginUser loginUser;

    @Autowired
    ConvertService convertService;

    @PostMapping("")
    public String success(String listFile, Model model) throws IOException {
        convertService.Convert(listFile);
        return "successpage";
    }
}
