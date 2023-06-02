package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.controller"})
public class Lab25122Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab25122Application.class, args);
    }

}
