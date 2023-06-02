package com.example;

import com.example.pojo.Class;
import com.example.respository.ClassRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class Lab232ApplicationTests {

    @Autowired
    private ClassRepository classRepository;
//2040706101 杨艾琳
    @Test
    void addClassTest(){
        Class c=new Class();
        c.setClassId(100);
        c.setClassName("测试班级");
        c.setClassSize(60);
        classRepository.save(c);
    }

    @Test
    void updateClassTest(){
        Class c=new Class();
        c.setClassId(100);
        c.setClassName("testclass");
        c.setClassSize(50);
        classRepository.save(c);
    }

    @Test
    void findClassByIdTest(){
        Optional<Class> optionalClass=classRepository.findById(100);
        if (optionalClass.isPresent()) {
            System.out.println(optionalClass.get());
        }
    }
    //2040706101 杨艾琳
    @Test
    void findClassByClassNameTest(){
        Class c=classRepository.findClassesByClassName("测试班级");
        System.out.println(c);
    }

    @Test
    void deleteClassTest(){
        classRepository.deleteById(100);
    }

    @Test
    void contextLoads() {
    }

}
