package com.example.dao.impl;

import com.example.dao.TeacherDao;
import com.example.pojo.Teacher;

public class TeacherDaoImpl implements TeacherDao {
    @Override
    public int addTeacherInfo(Teacher teacher) {
        System.out.println("jobId:"+teacher.getJobId()+"添加成功!");
        return 1;
    }

    @Override
    public int updateTeacherInfo(String jobId) {
        System.out.println("jobId:"+jobId+"修改成功!");
        return 1;
    }

    @Override
    public int deleteTeacherInfo(String jobId) {
        System.out.println("jobId:"+jobId+"删除成功!");
        return 1;
    }

    @Override
    public Teacher queryTeacherInfoById(String jobId) {
        Teacher teacher=new Teacher("2040706101","0","0");
        System.out.println("jobId:"+jobId+"查询成功!");
        return teacher;
    }
}
