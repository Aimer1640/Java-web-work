package com.example.controller;

import com.example.dao.MajorDao;
import com.example.pojo.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MajorController {
    @Autowired
    private MajorDao majorDao;
    @RequestMapping("/toAddMajor")
    public String toAddMajor(){
        return "majorAdd";
    }
    //2040706101 杨艾琳
    @RequestMapping("/addMajor")
    public String addMajor(Major major){
        int rows=majorDao.addMajor(major);
        return "redirect:showAllMajors";
    }

    @GetMapping("/updateMajor")
    public String toUpdateMajor(String majorId,Model model){
        Major major=majorDao.findMajorById(majorId);
        model.addAttribute("major",major);
        return "majorUpdate";
    }

    @PostMapping("/updateMajor")
    public String updateMajor(Major major){
        int rows=majorDao.updateMajor(major);
        return "redirect:showAllMajors";
    }

    @RequestMapping("/deleteMajor")
    public String deleteMajor(String majorId){
        int rows=majorDao.deleteMajorById(majorId);
        return "redirect:showAllMajors";
    }

    @RequestMapping("/deleteMajors")
    public String deleteMajors(String[] id){
        int rows=majorDao.deleteMajorsByIds(id);
        return "redirect:showAllMajors";
    }

    //2040706101 杨艾琳
    @RequestMapping("/showAllMajors")
    public String showAllMajors(Model model){
        List<Major> majorList=majorDao.findAllMajor();
        model.addAttribute("majorList",majorList);
        return "majorAll";
    }

    //根据系部id查询专业
    @RequestMapping("/findMajorsByDeptId")
    @ResponseBody
    public List<Major> findMajorsByDeptId(int deptId){
        List<Major> majors=majorDao.findMajorsByDeptId(deptId);
        return majors;
    }

}
