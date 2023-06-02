package com.example.service.impl;

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

    @Override
    public List<Major> findMajorsByMajorNameContainsAndDeptId(String majorName) {
        return majorRepository.findMajorsByMajorNameContainsAndDeptId(majorName);
    }
}
