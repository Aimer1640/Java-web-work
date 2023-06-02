package com.example.service.impl;

import com.example.pojo.Dept;
import com.example.pojo.Major;
import com.example.repository.DeptRespository;
import com.example.repository.MajorRepository;
import com.example.service.DeptAndMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptAndMajorServiceImpl implements DeptAndMajorService {

    @Autowired
    private MajorRepository majorRepository;

    @Autowired
    private DeptRespository deptRespository;

    @Override
    public List<Major> findByMajorNameContains(String majorName) {
        return majorRepository.findByMajorNameContains(majorName);
    }

    @Override
    public Dept findDeptWithMajor(Integer id) {
        return deptRespository.findByDeptId(id);
    }
}
