package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages="controller")
@MapperScan("com.example.mapper")
public class Lab212Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab212Application.class, args);
    }

}
