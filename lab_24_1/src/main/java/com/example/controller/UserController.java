package com.example.controller;

import com.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/login")
    public String toLogin(){
        return "freshman";
    }
    @PostMapping("/login")
    public String Login(User user, Model model){
        if (user.getAccount().equals("101")&&user.getPassword().equals("101")&&user.getRoleId()==1){
            return "index";
        }
        else {
            model.addAttribute("msg","账号或密码错误！");
            return "login";
        }
    }

}
