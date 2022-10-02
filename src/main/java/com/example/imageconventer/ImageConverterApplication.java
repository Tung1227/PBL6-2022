package com.example.imageconventer;

import com.example.imageconventer.model.entity.User;
import com.example.imageconventer.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImageConverterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageConverterApplication.class, args);
    }

}
