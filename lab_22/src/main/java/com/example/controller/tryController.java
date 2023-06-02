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
public class tryController {
    @Autowired
    private MajorRepository majorRepository;

    @RequestMapping("/findMajor")
    public List<Major> findMajorbyMajaorName(String majorName){
        return majorRepository.findMajorsByMajorNameContainsAndDeptId(majorName);
    }

}
