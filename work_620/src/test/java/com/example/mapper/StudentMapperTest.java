package com.example.mapper;

import com.example.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentMapperTest {
    @Autowired(required = false)
    private StudentMapper studentMapper;
    @Test
    void findAllStudent() {
        List<Student> students = studentMapper.findAllStudent();
        students.forEach(System.out::println);
    }
}