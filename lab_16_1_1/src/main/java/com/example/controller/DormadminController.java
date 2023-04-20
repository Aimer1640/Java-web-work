package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dormadmin")
public class DormadminController {
    @RequestMapping("/toDormadmin")
    public String toDormadmin(){
        return "dormadmin/dormadmin";
    }
}
