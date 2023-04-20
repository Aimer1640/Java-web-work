package com.example.service.impl;

import com.example.mapper.TeacherMapper;
import com.example.pojo.Student;
import com.example.pojo.Teacher;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public int registerTeacher(Teacher teacher) {
        int n=this.teacherMapper.registerTeacher(teacher);
        return n;
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        int n=this.teacherMapper.updateTeacher(teacher);
        return n;
    }

    @Override
    public int deleteTeacherById(String teacherId) {
        int n=this.teacherMapper.deleteTeacherById(teacherId);
        return n;
    }

    @Override
    public Teacher findTeacherById(String teacherId) {
        Teacher teacher=this.teacherMapper.findTeacherById(teacherId);
        return teacher;
    }

    @Override
    public List<Teacher> findAllTeacher() {
        List<Teacher> teachers=this.teacherMapper.findAllTeacher();
        return teachers;
    }

}
