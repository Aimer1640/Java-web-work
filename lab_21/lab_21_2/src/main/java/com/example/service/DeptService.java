package com.example.service;

import com.example.pojo.Dept;

import java.util.List;

public interface DeptService {
    int addDept(Dept dept);
    List<Dept> findAll();
    int updateDept(Dept dept);
    int deleteDept(Dept dept);
}
