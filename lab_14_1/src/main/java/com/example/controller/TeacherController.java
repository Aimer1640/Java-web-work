package com.example.controller;

import com.example.dao.TeacherDao;
import com.example.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private TeacherDao teacherDao;

    @RequestMapping("/findTeacherByRoleId")
    @ResponseBody
    public List<Teacher> findTeacherByRoleId(int roleId){
        return teacherDao.findTeacherByRole(roleId);
    }
}
