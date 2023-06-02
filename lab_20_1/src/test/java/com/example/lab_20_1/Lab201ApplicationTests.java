package com.example.lab_20_1;

import com.example.pojo.FreshmanProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lab201ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private FreshmanProperties freshmanProperties;

    @Test
    void freshmanPropertiesTest(){
        System.out.println(freshmanProperties);
    }
}
