package com.example.controller;

import com.example.mapper.PersonMapper;
import com.example.mapper.UserMapper;
import com.example.pojo.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping("/test")
public class PersonController {
    @Autowired
    private PersonMapper personMapper;

    @RequestMapping("/find")
    public boolean userfind(String user_name ,String user_pwds,String user_role){
        System.out.println(user_name+","+user_pwds+","+user_role);
        Persons persons = personMapper.findUser(user_name,user_pwds,user_role);
        if(persons != null){
            return true;
        }
        return false;
    }

//    @RequestMapping("/addCoursework")
//    public boolean add(@RequestBody User user){
//        System.out.println("添加成功");
//        return userService.save(user);
//    }

}
