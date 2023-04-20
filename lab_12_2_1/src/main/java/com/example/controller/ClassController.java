package com.example.controller;

import com.example.dao.ClassDao;
import com.example.pojo.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ClassController {
    @Autowired
    private ClassDao classDao;

    @RequestMapping("toAddClass")
    public String toAddClass(){
        return "majorForm";
    }

    @RequestMapping("addClass")
    public String addClass(Class c){
        int rows=classDao.addClass(c);
        return "redirect:findAllClasses";

    }

    @RequestMapping("findAllClasses")
    public String showAllClasses(Model model){
        List<Class> classes=classDao.findAllClasses();
        model.addAttribute("classList",classes);
        return "showAllClasses";
    }
}
