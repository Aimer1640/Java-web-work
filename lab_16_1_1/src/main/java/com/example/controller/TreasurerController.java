package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/treasurer")
public class TreasurerController {
    @RequestMapping("/toTreasurer")
    public String toTreasurer(){
        return "treasurer/treasurer";
    }
}