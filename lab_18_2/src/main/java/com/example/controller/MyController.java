package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    //2040706101 杨艾琳
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello，2040706101，Spring Initializr！";
    }
}
