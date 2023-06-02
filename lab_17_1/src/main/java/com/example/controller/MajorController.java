package com.example.controller;

import com.example.mapper.MajorMapper;
import com.example.pojo.Major;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/officer")
public class MajorController {
    @Resource
    private MajorMapper majorMapper;
    //跳转到添加专业页面
    @RequestMapping(value = "/addMajor",method = RequestMethod.GET)
    public String toAddMajor(){
        return "/officer/addMajor";
    }

    //添加专业信息
    @RequestMapping(value = "/addMajor",method = RequestMethod.POST)
    public String addMajor(Major major){
        int rows=majorMapper.addMajor(major);
        return "redirect:/officer/findAllMajors";
    }
    //查询所有专业
    @RequestMapping("/findAllMajors")
    public String findAllMajors(Model model,HttpSession session){
        List<Major> majorList=majorMapper.findAllMajors();
        model.addAttribute("majorList",majorList);
        session.setAttribute("majorList",majorList);
        return "/officer/showAllMajors";

    }
    //根据majorId查询专业信息
    @RequestMapping(value="/findMajorByMajorId")
    public String findMajorByMajorId(String majorId,Model model){
        Major major=majorMapper.findMajorById(majorId);
        model.addAttribute("major",major);
        return "/officer/updateMajor";
    }

    //根据majorId查询专业信息
    @RequestMapping(value="/findMajorByDeptId")
    @ResponseBody
    public List<Major> findMajorByDeptId(Integer deptId){
        List<Major> majors=majorMapper.findMajorByDeptId(deptId);
        return majors;
    }

    //修改专业信息
    @RequestMapping(value="/updateMajor")
    public String updateMajor(Major major){
        int rows=majorMapper.updateMajor(major);
        return "redirect:/officer/findAllMajors";
    }

    //根据majorId删除专业信息
    @RequestMapping(value="/deleteMajorByMajorId")
    public String deleteMajorByMajorId(String majorId){
        System.out.println("删除"+majorId);
        int rows=majorMapper.deleteMajorById(majorId);
        return "redirect:/officer/findAllMajors";
    }

    @RequestMapping("deleteMajorsByIds")
    public String deleteMajorsByIds(String[] id){
        majorMapper.bathDeleteMajor(id);
        return "redirect:/officer/findAllMajors";
    }
}
