package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secretary")
public class SecretaryController {
    @RequestMapping("/toSecretary")
    public String toSecretary(){
        return "secretary/secretary";
    }
}