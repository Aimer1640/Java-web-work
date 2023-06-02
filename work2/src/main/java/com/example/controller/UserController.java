package com.example.controller;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Resource
    private UserMapper userMapper;

    @GetMapping("/login")
    public String login(){
        return "redirect:/login.jsp";
    }
    //2040706101 杨艾琳
    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model) {
        User u = userMapper.login(user);
        if (u != null) {
            session.setAttribute("USER_SESSION", u);
            if (u.getRoleId() == 5) {
                return "redirect:freshman/toFreshman";
            } else if (u.getRoleId() == 2) {
                return "student/student";
            } else if (u.getRoleId() == 1) {
                return "teacher/teacher";
            }else {
                return "administrator/administrator";
            }
        }else {
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }
    }
}

