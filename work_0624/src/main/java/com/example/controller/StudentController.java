package com.example.controller;

import com.example.mapper.StudentMapper;
import com.example.pojo.Student;
import com.example.util.PageUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentMapper studentMapper;

    @RequestMapping("/findAllStudents")
    public String findAllStudents(@RequestParam Map<String, String> map, Model model) {
        System.out.println("map:"+map);
        if (map.size() == 0 || map.get("currentPage").isEmpty()) {
            map.put("currentPage", "1");
        }
//        map.put("currentPage", "1");
        // 从数据库中查询出信息
        List<Student> students = studentMapper.findAllStudent();
        System.out.println("students"+students);
        PageUtil pageInfo = new PageUtil(Integer.valueOf(map.get("currentPage")), 5, students);
        model.addAttribute("studentList", pageInfo.getList());
        System.out.println("pageInfo:"+pageInfo);

        model.addAttribute("pageInfo", pageInfo);
        return "/student/showAllStudents";
    }

    @RequestMapping("/absenceStudent")
    public String absenceStudent(Model model) {
        List<Student> students = studentMapper.findAllStudent();
        model.addAttribute("studentList", students);
        System.out.println(students);
        return "/teacher/showAbsence";
    }

    @GetMapping(value = "/addStudent")
    public String toaddStudent() {
        return "administrator/addStudent";
    }

    @PostMapping(value = "/addStudent")
    public String addStudent(Student s) {
//        c.setDeptId(407);
        int rows = studentMapper.registerStudent(s);
        return "redirect:/student/findAllStudents";
    }

    @RequestMapping("/deleteStudentById")
    public String deleteStudentById(String studentId, HttpServletRequest request) {
        int rows = studentMapper.deleteStudentById(studentId);
        String contextPath = request.getContextPath();
        return "redirect:/student/findAllStudents";
    }

    @RequestMapping("/findStudentByStudentId")
    public String findStudentByStudentId(String studentId, Model model) {
        System.out.println("studentId:" + studentId);
        Student s = studentMapper.findStudentById(studentId);
        model.addAttribute("s", s);
        System.out.println(s);
        return "administrator/updateStudent";
    }

    @RequestMapping("/absenceStudentByStudentId")
    public String absenceStudentByStudentId(String studentId, Model model) {
        System.out.println("studentId:" + studentId);
        Student s = studentMapper.findStudentById(studentId);
        model.addAttribute("s", s);
        System.out.println(s);
        return "teacher/absenceStudent";
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(Student s) {
        System.out.println(s);
        int rows = studentMapper.updateStudent(s);
        return "redirect:/student/findAllStudents";
    }
}
