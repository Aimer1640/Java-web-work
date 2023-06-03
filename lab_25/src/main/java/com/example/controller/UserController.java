package com.example.controller;
import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {
    @Resource

    private UserMapper userMapper;
    @GetMapping("/login")
    public String toLogin(){
        return "public/login";
    }

    //2040706101 杨艾琳
    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model) {
        System.out.println("user:"+user);

        User u = userMapper.login(user);
        System.out.println("u:"+u);

        if (u != null) {
            session.setAttribute("USER_SESSION", u);
            if (user.getRoleId() == 2) {
                return "student/student";
            } else if (user.getRoleId() == 1) {
                return "teacher/teacher";
            }else {
                return "administrator/administrator";
            }
        }else {
            model.addAttribute("msg","用户名或密码错误");
            return "public/login";
        }
    }
}
