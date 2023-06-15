package com.example.controller;

import com.example.mapper.StudentMapper;
import com.example.pojo.Student;
import com.example.pojo.User;
import com.example.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentMapper studentMapper;

    @RequestMapping("/findAllStudents")
    public String findAllStudents(@RequestParam Map<String, String> map, Model model) {
        if (map.size() == 0 || map.get("currentPage").isEmpty()) {
            map.put("currentPage", "1");
        }
        // 从数据库中查询出信息
        List<Student> students = studentMapper.findAllStudent();
        PageUtil pageInfo = new PageUtil(Integer.valueOf(map.get("currentPage")), 5, students);
        model.addAttribute("studentList", pageInfo.getList());
        System.out.println("pageInfo:"+pageInfo);
        System.out.println("students"+students);
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

    @GetMapping("/toUpload")
    public String toUpload() {
        return "/upload";
    }

    //2040706101 杨艾琳
    @PostMapping("/toUpload")
    public String uploadFile(@RequestParam("uploadFile") List<MultipartFile> uploadFile, HttpSession session, HttpServletRequest request) {
        if (!uploadFile.isEmpty() && uploadFile.size() > 0) {
            for (MultipartFile file : uploadFile) {
                String originalFilename = file.getOriginalFilename();
                String dirPath = request.getRealPath("/upload");
                System.out.println(dirPath);
                File filePath = new File(dirPath);
                // 如果保存文件的地址不存在，就先创建目录
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                User user = (User) session.getAttribute("USER_SESSION");
                String newFilename = user.getAccount() + "_" + UUID.randomUUID() +
                        "_" + originalFilename;
                System.out.println(dirPath + File.separator + newFilename);
                try {
                    // 使用MultipartFile接口的方法完成文件上传到指定位置
                    file.transferTo(new File(dirPath + File.separator + newFilename));
                } catch (Exception e) {
                    e.printStackTrace();
                    return "/error";
                }
            }
            // 跳转到成功页面
            return "administrator/administrator";
        } else {
            return "error";
        }
    }

}
