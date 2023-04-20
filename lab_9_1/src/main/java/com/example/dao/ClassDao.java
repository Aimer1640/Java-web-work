package com.example.dao;

import com.example.pojo.Class;

import java.util.List;

public interface ClassDao {
    //添加班级
    public int addClass(Class c);

    //更新班级
    public int updateClass(Class c);

    //删除某个班级
    public int deleteClassById(Integer ClassId);

    //根据班级名称查询班级
    public List<Class> findClassByName(String ClassName);

    //查询某个系的所有班级
    public List<Class> findAllClassByDept(Integer ClassId);

    //查询某个专业的所有班级
    public List<Class> findAllClassByMajor(Integer majorId);
}
