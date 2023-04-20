package com.example.service;

import com.example.pojo.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface StudentService {
    //注册学生账号
    public int registerStudent(Student student);

    //更新学生信息
    public int updateStudent(Student student);

    //删除学生
    public int deleteStudentById(String studentId);

    //根据id查询学生
    public Student findStudentById(String studentId);

    //查询所有学生
    public List<Student> findAllStudent();

    //缺勤
    public int absenceStudent(Student student);
}
