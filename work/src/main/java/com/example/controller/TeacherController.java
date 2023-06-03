package com.example.controller;

import com.example.mapper.TeacherMapper;
import com.example.pojo.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/teacher")

public class TeacherController {

    @Resource
    private TeacherMapper teacherMapper;

    @RequestMapping("/toTeacher")
    public String toTeacher(){
        return "teacher/teacher";
    }

    @RequestMapping("/findAllTeachers")
    public String findAllTeachers(Model model){
        List<Teacher> teachers=teacherMapper.findAllTeacher();
        model.addAttribute("teacherList",teachers);
        System.out.println(teachers);
        return "public/showAllTeachers";
    }

    @GetMapping(value = "/addTeacher")
    public String toaddTeacher(){
        return "administrator/addTeacher";
    }

    @PostMapping(value = "/addTeacher")
    public String addTeacher(Teacher t){
        int rows=teacherMapper.registerTeacher(t);
        return "redirect:/teacher/findAllTeachers";
    }

    @RequestMapping("/deleteTeacherById")
    public String deleteTeacherById(String teacherId, HttpServletRequest request){
        int rows=teacherMapper.deleteTeacherById(teacherId);
        String contextPath=request.getContextPath();
        return "redirect:/teacher/findAllTeachers";
    }

    @RequestMapping("/findTeacherByTeacherId")
    public String findTeacherByTeacherId(String teacherId, Model model){
        System.out.println("teacherId"+teacherId);
        Teacher t=teacherMapper.findTeacherById(teacherId);
        model.addAttribute("t",t);
        System.out.println(t);
        return "administrator/updateTeacher";
    }

    @RequestMapping("/updateTeacher")
    public String updateTeacher(Teacher t){
        System.out.println(t);
        int rows=teacherMapper.updateTeacher(t);
        return "redirect:/teacher/findAllTeachers";
    }

}
