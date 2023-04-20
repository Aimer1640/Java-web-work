package com.example.controller;

import com.example.dao.UserDao;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        User user1=userDao.login(user);
        if (user1!=null){
            session.setAttribute("user",user1);
            return "index";
        }else {
//            return "index";
            return "redirect:login.html";
        }
    }
}
