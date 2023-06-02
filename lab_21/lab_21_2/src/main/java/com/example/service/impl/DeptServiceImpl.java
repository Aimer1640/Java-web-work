package com.example.service.impl;

import com.example.mapper.DeptMapper;
import com.example.pojo.Dept;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public int addDept(Dept dept) {
        return deptMapper.insert(dept);
    }

    @Override
    public List<Dept> findAll() {
        return deptMapper.selectList(null);
    }

    @Override
    public int updateDept(Dept dept) {
        return deptMapper.updateById(dept);
    }

    @Override
    public int deleteDept(Dept dept) {
        return deptMapper.deleteById(dept);
    }


}
