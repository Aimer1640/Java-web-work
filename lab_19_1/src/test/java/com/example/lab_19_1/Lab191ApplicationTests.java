package com.example.lab_19_1;

import com.example.pojo.Freshman;
import com.example.pojo.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lab191ApplicationTests {

    @Autowired
    private Role role;

    @Autowired
    private Freshman freshman;
    @Test
    void contextLoads() {
    }

    @Test
    void roleTest(){
        System.out.println(role);
    }

    @Test
    void freshmanTest(){
        System.out.println(freshman);
    }

}
