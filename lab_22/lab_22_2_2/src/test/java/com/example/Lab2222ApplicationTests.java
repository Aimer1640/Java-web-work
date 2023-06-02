package com.example;

import com.example.pojo.Dept;
import com.example.pojo.Major;
import com.example.repository.DeptRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lab2222ApplicationTests {
    @Autowired
    private DeptRespository deptRespository;

    @Test
    void findByDeptId(){
        Dept depts=deptRespository.findByDeptId(407);
        System.out.println(depts);
//        for (Dept d:depts){
//            System.out.println(m);
//        }
//        List<Major> majors=majorRepository.findByMajorNameContains("计算机");
//        for (Major m:majors){
//            System.out.println(m);
//        }
    }
    @Test
    void contextLoads() {
    }

}
