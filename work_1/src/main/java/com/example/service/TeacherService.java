package com.example.service;

import com.example.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    //注册教师账号
    public int registerTeacher(Teacher teacher);

    //更新教师信息
    public int updateTeacher(Teacher teacher);

    //删除教师
    public int deleteTeacherById(String teacherId);

    //根据id查询教师
    public Teacher findTeacherById(String teacherId);

    //查询所有教师
    public List<Teacher> findAllTeacher();
}
