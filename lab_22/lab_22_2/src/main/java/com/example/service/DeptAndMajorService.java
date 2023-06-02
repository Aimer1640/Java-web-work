package com.example.service;

import com.example.pojo.Major;

import java.util.List;

public interface DeptAndMajorService {
    //查询专业

    public List<Major> findByMajorNameContains(String majorName);
}
