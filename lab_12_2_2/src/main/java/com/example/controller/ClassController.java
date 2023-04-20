package com.example.controller;

import com.example.dao.ClassDao;
import com.example.pojo.Class;
import com.example.pojo.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ClassController {
    @Autowired
    private ClassDao classDao;
    //2040706101 杨艾琳
    @RequestMapping("/toAddClass")
    public String toAddClass(){
        return "addClass";
    }

    @RequestMapping("/allClass")
    public String addClass(Class c){
        int rows=classDao.addClass(c);
        return "redirect:showAllClasses";
    }

    @RequestMapping("/updateClass")
    public String updateClass(Class c){
        int rows=classDao.updateClass(c);
        return "updateClass";
    }
    @RequestMapping("/deleteClassById")
    public String deleteClass(String classId){
        int rows=classDao.deleteClassById(classId);
        return "redirect:showAllClasses";
    }
    //2040706101 杨艾琳
    @RequestMapping("/showAllClasses")
    public String showAllClasses(Model model){
        List<Class> classes=classDao.findAllClasses();
        model.addAttribute("classList",classes);
        return "showAllClasses";
    }
}
