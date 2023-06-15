package com.example.controller;

import com.example.mapper.TeacherMapper;
import com.example.pojo.Student;
import com.example.pojo.Teacher;
import com.example.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
    public String findAllTeachers(@RequestParam Map<String, String> map, Model model){
        if (map.size() == 0 || map.get("currentPage").isEmpty()) {
            map.put("currentPage", "1");
        }
        // 从数据库中查询出信息
        List<Teacher> teachers=teacherMapper.findAllTeacher();
        PageUtil pageInfo = new PageUtil(Integer.valueOf(map.get("currentPage")), 5, teachers);
        model.addAttribute("teacherList", pageInfo.getList());
        System.out.println("pageInfo:"+pageInfo);
        System.out.println("teachers"+teachers);
        model.addAttribute("pageInfo", pageInfo);
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
