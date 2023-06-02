package com.example.controller;

import com.example.mapper.ClassMapper;
import com.example.pojo.Class;
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
@RequestMapping("/officer")
public class ClassController {
    @Resource
    private ClassMapper classMapper;

    @RequestMapping("/findAllClasses")
    public String findAllClasses(Model model){
        List<Class> classes=classMapper.findAllClassByDept(407);
        model.addAttribute("classList",classes);
        return "showAllClasses";
    }

    @GetMapping(value = "/addClass")
    public String toAddClass(){
        return "/addClass";
    }

    @PostMapping(value = "/addClass")
    public String addClass(Class c){
        c.setDeptId(407);
        int rows=classMapper.addClass(c);
        return "redirect:/officer/findAllClasses";
    }

    /**
     * 删除班级
     */
    @RequestMapping("/deleteClassByClassId/{classId}")
    public String  deleteClassById(@PathVariable Integer classId, HttpServletRequest request) {
        int rows=classMapper.deleteClassById(classId);
        String contextPath=request.getContextPath();
        return "redirect:/officer/findAllClasses";
    }

    /**
     * 根据班级id批量删除
     */
    @RequestMapping("/deleteClassesByIds")
    public String deleteClassesByIds(String[] id){
        int rows=classMapper.deleteClassesByIds(id);
        return "redirect:/officer/findAllClasses";
    }

    /**
     * 根据班级ID查询班级信息
     */
    @RequestMapping("/findClassByClassId/{classId}")
    public String findClassByClassId(@PathVariable("classId") Integer classId,Model model){
        System.out.println(classId);
        Class c=classMapper.findClassById(classId);
        model.addAttribute("c",c);
        return "/updateClass";
    }

    /**
     * 修改班级信息
     */
    @RequestMapping("/updateClass")
    public String updateClass(Class c){
        System.out.println(c);
        int rows=classMapper.updateClass(c);
        return "redirect:/officer/findAllClasses";

    }
}
