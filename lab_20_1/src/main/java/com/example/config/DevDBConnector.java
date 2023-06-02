package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevDBConnector implements DBConnector{
    @Override
    public void configure() {
        System.out.println("开发环境");
    }
}
