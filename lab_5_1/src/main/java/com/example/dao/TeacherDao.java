package com.example.dao;

import com.example.pojo.Teacher;

public interface TeacherDao {
    int addTeacherInfo(Teacher teacher);
//    int updateTeacherInfo(Teacher teacher);
    int updateTeacherInfo(String jobId);
    int deleteTeacherInfo(String jobId);
    Teacher queryTeacherInfoById(String jobId);
}
