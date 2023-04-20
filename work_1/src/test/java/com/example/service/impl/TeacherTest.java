package com.example.service.impl;

import com.example.mapper.StudentMapper;
import com.example.mapper.TeacherMapper;
import com.example.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {
    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-bean.xml");
    TeacherMapper teacherMapper=applicationContext.getBean(TeacherMapper.class);

    @Test
    void registerTeacher() {
        Teacher teacher=new Teacher();
        teacher.setTeacherId("007");
        teacher.setTeacherName("yal");
        teacher.setMajorId("07");
        teacher.setDeptId("407");
        teacher.setRole(1);
        int rows=teacherMapper.registerTeacher(teacher);
        if (rows>0){
            System.out.println("添加成功");
        }
        else {
            System.out.println("添加失败");
        }
    }

    @Test
    void updateTeacher() {
        Teacher teacher=new Teacher();
        teacher.setTeacherId("007");
        teacher.setTeacherName("y");
        teacher.setMajorId("07");
        teacher.setDeptId("407");
        teacher.setRole(1);
        int rows=teacherMapper.updateTeacher(teacher);
        if (rows>0){
            System.out.println("更新成功");
        }
        else {
            System.out.println("更新失败");
        }
    }

    @Test
    void deleteTeacherById() {
        int rows=teacherMapper.deleteTeacherById("07");
        if (rows>0){
            System.out.println("删除成功");
        }
        else {
            System.out.println("删除失败");
        }
    }

    @Test
    void findTeacherById() {
        Teacher teacher=teacherMapper.findTeacherById("02");
        System.out.println(teacher);
    }

    @Test
    void findAllTeacher() {
        List<Teacher> teacherList=teacherMapper.findAllTeacher();
        for (Teacher t:teacherList){
            System.out.println(t);
        }
    }
}