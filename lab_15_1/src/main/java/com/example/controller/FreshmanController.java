package com.example.controller;

import com.example.dao.FreshmanDao;
import com.example.dao.MajorDao;
import com.example.pojo.Freshman;
import com.example.pojo.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/freshman")
public class FreshmanController {
    @Resource
    private FreshmanDao freshmanDao;

    @RequestMapping("/toFreshman")
    public String toFreshman(){
        return "freshman/freshman";
    }
    //2040706101 杨艾琳
    @GetMapping("/freshmanUpdate")
    public String updateFreshman(String ticketNumber,Model model){
        Freshman freshman=freshmanDao.findFreshmanByticketNumber(ticketNumber);
        model.addAttribute("freshman",freshman);
        return "freshman/freshmanUpdate";
    }

    @PostMapping("/freshmanUpdate")
    public String updateFreshman(Freshman freshman){
        int rows=freshmanDao.updateFreshman(freshman);
        return "freshman/freshmanUpdate";
    }

}