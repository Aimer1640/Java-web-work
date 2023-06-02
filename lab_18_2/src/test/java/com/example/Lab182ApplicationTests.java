package com.example;

import com.example.controller.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lab182ApplicationTests {

    @Autowired
    MyController myController;

    @Test
    void contextLoads() {
    }

    //2040706101 杨艾琳
    @Test
    public void sayHelloTest(){
        System.out.println(myController.sayHello());
    }
}
