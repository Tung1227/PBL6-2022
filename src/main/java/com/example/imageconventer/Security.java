package com.example.imageconventer;

import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class Security extends Appl {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/css/**", "/js/**", "/images/**").permitAll();
        http.csrf().disable().cors();
    }
}
