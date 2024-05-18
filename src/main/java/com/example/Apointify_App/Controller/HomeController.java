package com.example.Apointify_App.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("index")
    public String home() {
        return "index"; // Assuming "index" is your home page template
    }
}