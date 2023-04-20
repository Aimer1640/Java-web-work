package com.example.controller;

import com.example.dao.UserDao;
import com.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/user")
public class UserController {
    @Resource
    private UserDao userDao;



    @GetMapping("/login")
    public String login(){
        return "forward:/login.jsp";
    }
    //2040706101 杨艾琳
    @PostMapping("/login")
    public String login(User user,HttpSession session) {
        User u = userDao.login(user);
        if (u != null) {
            session.setAttribute("USER_SESSION", u);
            if (u.getRoleId() == 5) {
                return "redirect:freshman/toFreshman";
            } else if (u.getRoleId() == 4) {
                return "redirect:secretary/toSecretary";
            } else if (u.getRoleId() == 3) {
                return "redirect:dormadmin/toDormadmin";
            } else if (u.getRoleId() == 2) {
                return "redirect:treasurer/toTreasurer";
            } else if (u.getRoleId() == 1) {
                return "redirect:officer/toOfficer";
            }else {
                return "redirect:admin/toAdmin";
            }
        }else {
            return "redirect:login.jsp";
        }
    }
}

