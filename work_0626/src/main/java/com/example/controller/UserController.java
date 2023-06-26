package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/login")
    public String toLogin(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "login";
    }

    @GetMapping("/getUser")
    @ResponseBody
    public String getUser(){
        SecurityContext securityContext= SecurityContextHolder.getContext();
        Authentication authentication=securityContext.getAuthentication();
        UserDetails principal=(UserDetails) authentication.getPrincipal();
        return principal.getUsername();
    }
    @RequestMapping("/find")
    public boolean userfind(String user_name ,String user_pwds){
        System.out.println(user_name+","+user_pwds);
        User user = userService.finduser(user_name,user_pwds);
        if(user != null){
            return true;
        }
        return false;
    }

}
