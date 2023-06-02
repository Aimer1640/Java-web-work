package com.example.controller;

import com.example.pojo.Teacher;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    //2040706101 杨艾琳
    @GetMapping("/get/{jobId}")
    public Teacher findByJobId(@PathVariable String jobId){
        return teacherService.findByJobId(jobId);
    }

    @GetMapping("/update/{jobId}/{tName}")
    public Teacher updateTeacherBuJobId(@PathVariable String jobId,@PathVariable("tName") String teacherName){
        Teacher t=teacherService.findByJobId(jobId);
        System.out.println(t);
        t.setTeacherName(teacherName);
        return teacherService.updateTeacherByJobId(t);

    }

    @GetMapping("/delete/{jobId}")
    public void deleteTeacherByJobId(@PathVariable String jobId){
        teacherService.deleteTeacherByJobId(jobId);
    }
}
