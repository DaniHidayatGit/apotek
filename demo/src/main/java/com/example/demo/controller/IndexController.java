package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexController {

    @GetMapping("/")
    public RedirectView index(){
        return new RedirectView("/login");
    }

    @GetMapping("/tentang")
    public String tentang(){
        return "tentang";
    }

    @GetMapping("/contactUs")
    public String contactUs(){
        return "contactUs";
    }
}
