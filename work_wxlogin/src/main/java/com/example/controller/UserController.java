package com.example.controller;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/find")
    public boolean userfind(String user_name ,String user_pwds,String user_role){
        System.out.println(user_name+","+user_pwds+","+user_role);
        User user = userMapper.findUser(user_name,user_pwds,user_role);
        if(user != null){
            return true;
        }
        return false;
    }

}
