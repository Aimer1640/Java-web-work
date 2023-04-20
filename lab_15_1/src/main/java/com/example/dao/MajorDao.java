package com.example.dao;

import com.example.pojo.Major;
import java.util.List;

public interface MajorDao {
    //添加专业
    int addMajor(Major major);

    //更新专业
    int updateMajor(Major major);

    //删除专业
    int deleteMajorById(String majorId);

    //根据id查询专业
    Major findMajorById(String majorId);
    
    //查询所有专业
    List<Major> findAllMajor();

    //批量删除
    public void bathDeleteMajor(String []majorIds);

    //根据系别查询专业
    List<Major> findMajorByDeptId(Integer dept_id);
}
