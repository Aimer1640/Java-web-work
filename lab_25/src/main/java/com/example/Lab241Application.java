package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan("com.example.mapper")
@SpringBootApplication
public class Lab241Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab241Application.class, args);
    }

}
