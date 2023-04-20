package com.example.dao;

import com.example.pojo.Major;

import java.util.List;

public interface MajorDao {
    public int addMajor(Major major);
    public List<Major> findAllMajors();

    Major findMajorByMajorId(String majorId);

    int updateMajor(Major major);

    int deleteMajorByMajorId(String majorId);

    public int deleteMajorsByIds(String[] id);

    List<Major> findMajorsByDeptId(Integer deptId);
    //查询所有专业
    public List<Major> findAllMajor();
}
