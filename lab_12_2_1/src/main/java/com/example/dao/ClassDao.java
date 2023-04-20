package com.example.dao;

import com.example.pojo.Class;

import java.util.List;

public interface ClassDao {
    public int addClass(Class c);
    int updateClass(Class c);
    int deleteClassById(Integer classId);
    Class findClassById(Integer classId);
    List<Class> findAllClasses();
}
