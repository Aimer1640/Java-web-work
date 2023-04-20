package com.example.controller;

import com.example.dao.ClassDao;
import com.example.pojo.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClassController {
    @Autowired
    private ClassDao classDao;
    //2040706101 杨艾琳
//    @RequestMapping("/toAddClass")
//    public String toAddClass(){
//        return "addClass";
//    }

//    @RequestMapping("/allClass")
//    public String addClass(Class c){
//        int rows=classDao.addClass(c);
//        return "redirect:showAllClasses";
//    }

//    @RequestMapping("/updateClass")
//    public String updateClass(Class c){
//        int rows=classDao.updateClass(c);
//        return "updateClass";
//    }
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
        return "classAll";
    }

    @RequestMapping("/findClassesByDept")
    public String findClassesByDept(Model model){
        List<Class> classes=classDao.findAllClassByDept(407);
        model.addAttribute("classList",classes);
        return "classAll";
    }

    @RequestMapping("/deleteClassById/{classId}")
    public String deleteClassById(@PathVariable int classId){
        int rows=classDao.deleteClassById(classId);
        return "redirect:/findClassesByDept";
    }

//    @RequestMapping("/toAddClass")
//    public String toAddClass(){
//        return "classAdd";
//    }
//2040706101 杨艾琳
    //添加班级
    @GetMapping("/addClass")
    public String toAddClass(){
        return "classAdd";
    }
    @PostMapping("/addClass")
    public String addClass(Class c){
        c.setDeptId(407);
        int rows=classDao.addClass(c);
        return "redirect:/findClassesByDept";
    }

    //跳转页面
//    @RequestMapping("/findClassByClassId")
    @GetMapping("/findClassByClassId")
    public String toUpdateClass(int classId,Model model){
        Class c=classDao.findClassById(classId);
        model.addAttribute("c",c);
        return "classUpdate";
    }
    //2040706101 杨艾琳
//    @PostMapping("/updateClass")
//    public String updateClass(Class c){
//        c.setDeptId(407);
//        int rows=classDao.updateClass(c);
//        return "redirect:/showAllClasses";
//    }


    @PostMapping("/updateClass")
//    @RequestMapping(value = "/updateClass",method = {RequestMethod.POST})
    @ResponseBody
    public String updateClass(@RequestBody Class c){
        System.out.println(c.getClassName());
        c.setDeptId(407);
        int rows=classDao.updateClass(c);
        return "redirect:/showAllClasses";
//        return "redirect:/showAllClasses";
    }
}
