package com.example.controller;

import com.example.pojo.Dept;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @RequestMapping("/addDept")
    public void addDept(){
        Dept dept=new Dept();
        dept.setDeptId(4073);
        dept.setDeptName("test2");
        deptService.addDept(dept);
    }
    @RequestMapping("/findAllDept")
    public List<Dept> findAllDepts(){
        return deptService.findAll();
    }

    @RequestMapping("/updateDept")
    public void updateDept(){
        Dept dept=new Dept();
        dept.setDeptId(4073);
        dept.setDeptName("newtest");
        deptService.updateDept(dept);
    }

    @RequestMapping("/deleteDept")
    public void deleteDept(){
        Dept dept=new Dept();
        dept.setDeptId(4073);
        deptService.deleteDept(dept);
    }
}
