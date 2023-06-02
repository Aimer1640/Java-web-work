package com.example.lab_22_2;

import com.example.pojo.Major;
import com.example.repository.MajorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Lab222ApplicationTests {

    @Autowired
    private MajorRepository majorRepository;

    @Test
    void findByMajorNameContainsTest(){
        List<Major> majors=majorRepository.findByMajorNameContains("计算机");
        for (Major m:majors){
            System.out.println(m);
        }
    }

    @Test
    void contextLoads() {
    }

}
