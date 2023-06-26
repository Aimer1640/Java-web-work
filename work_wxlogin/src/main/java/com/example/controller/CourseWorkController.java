package com.example.controller;

import com.example.entity.Coursework;
import com.example.mapper.CourseWorkMapper;

import jakarta.annotation.Resource;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coursework")
public class CourseWorkController {
    @Resource
    private CourseWorkMapper courseWorkMapper;

    @RequestMapping("/findAllCourseWorks")
    public List<Coursework> findAllCourseWork(){
        return courseWorkMapper.findAllWork();
    }

    @RequestMapping("/deleteCourseWork")
    public int delete(String uploadId){
        System.out.println(uploadId);
        return courseWorkMapper.retructWork(uploadId);
    }
}
