package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/officer")
public class OfficerController {
    @RequestMapping("/toOfficer")
    public String toOfficer(){
        return "officer/officer";
    }
}
