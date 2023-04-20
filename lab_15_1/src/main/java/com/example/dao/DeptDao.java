package com.example.dao;

import com.example.pojo.Dept;
import java.util.List;

public interface DeptDao {
    //添加系别
    int addDept(Integer deptId, String deptName);
    //更新系别
    int updateDept(Integer deptId, String deptName);
    //删除系别
    int deleteDeptById(Integer deptId);
    //根据id查询系别
    Dept findDeptById(Integer deptId);
    //查询所有系别
    List<Dept> findAllDept();
}
