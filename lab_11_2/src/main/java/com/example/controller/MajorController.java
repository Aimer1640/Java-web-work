package com.example.controller;

import com.example.dao.MajorDao;
import com.example.pojo.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MajorController {
    @Autowired
    private MajorDao majorDao;
    @RequestMapping("/toAddMajor")
    public String toAddMajor(){
        return "majorForm";
    }

    @RequestMapping("/saveMajor")
    public String addMajor(Major major){
        int rows=majorDao.addMajor(major);
        return "redirect:showAllMajors";
    }

    @RequestMapping("/updateMajor")
    public String updateMajor(Major major){
        int rows=majorDao.updateMajor(major);
        return "updateMajor";
    }
    @RequestMapping("/deleteMajor")
    public String deleteMajor(String majorId){
        int rows=majorDao.deleteMajorById(majorId);
        return "redirect:showAllMajors";
    }
    //2040706101 杨艾琳
    @RequestMapping("/showAllMajors")
    public String showAllMajors(Model model){
        List<Major> majorList=majorDao.findAllMajor();
        model.addAttribute("majorList",majorList);
        return "showAllMajors";
    }


}
