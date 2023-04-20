package com.example.service.impl;

import com.example.mapper.StudentMapper;
import com.example.pojo.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    //添加学生
    @Override
    public int registerStudent(Student student) {
        int n=this.studentMapper.registerStudent(student);
        return n;
    }

    @Override
    public int updateStudent(Student student) {
        int n=this.studentMapper.updateStudent(student);
        return n;
    }

    @Override
    public int deleteStudentById(String studentId) {
        int n=this.studentMapper.deleteStudentById(studentId);
        return n;
    }

    @Override
    public Student findStudentById(String studentId) {
        Student student=this.studentMapper.findStudentById(studentId);
        return student;
    }

    @Override
    public List<Student> findAllStudent() {
        List<Student> students=this.studentMapper.findAllStudent();
        return students;
    }

    @Override
    public int absenceStudent(Student student) {
        int n=this.studentMapper.absenceStudent(student);
        return n;
    }
}
