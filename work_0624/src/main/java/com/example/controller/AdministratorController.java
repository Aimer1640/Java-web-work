package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administrator")
public class AdministratorController {
    @RequestMapping("/toAdministrator")
    public String toAdmin(){
        return "administrator/administrator";
    }
}