package com.example.imageconventer.controller;

import com.example.imageconventer.model.dto.LoginUser;
import com.example.imageconventer.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.stream.FileImageInputStream;
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
        List<String> successList = convertService.Convert(listFile);
        model.addAttribute("successList", successList);
        if(!successList.isEmpty()){
            model.addAttribute("fileContent",convertService.readFile(successList.get(0)));
        }
        return "successpage";
    }

    @ResponseBody
    @PostMapping("/content")
    public String content(String fileName, Model model) throws IOException {
        return convertService.readFile(fileName);
    }

    @ResponseBody
    @PostMapping("/download")
    public ResponseEntity<Resource> download(String fileName, Model model) throws IOException {
        return convertService.DownloadFile(fileName);
    }
}
