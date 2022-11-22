package com.example.imageconventer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ImageConverterApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ImageConverterApplication.class, args);
    }


}
