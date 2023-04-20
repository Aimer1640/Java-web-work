package com.example.dao;

import com.example.pojo.Class;

import java.util.List;

public interface ClassDao {
    public int addClass(Class c);
    int updateClass(Class c);
    int deleteClassById(String classId);
    Class findClassById(Integer classId);
    List<Class> findAllClasses();
    //查询某个系的所有班级
    public List<Class> findAllClassByDept(Integer deptId);

    //查询某个专业的所有班级
    public List<Class> findAllClassByMajor(Integer majorId);
    //删除某个班级
    public int deleteClassById(Integer classId);
}
