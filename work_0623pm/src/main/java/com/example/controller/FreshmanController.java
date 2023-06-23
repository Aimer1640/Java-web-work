package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freshman")
public class FreshmanController {
    @RequestMapping("/toFreshman")
    public String toFreshman(){
        return "freshman/freshman";
    }

}
