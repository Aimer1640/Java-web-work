package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Major;
import com.example.repository.MajorRepository;
import com.example.service.DeptAndMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class OfficerController {
    @Autowired
    private DeptAndMajorService deptAndMajorService;

    @RequestMapping("/findMajorbyMajaorName")
    public List<Major> findMajorbyMajaorName(){
        return deptAndMajorService.findByMajorNameContains("计算机");
    }

}
