package org.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class convertcontroller {
    @GetMapping("/")
    public String hello(Model model){
        return "index";
    }
}
