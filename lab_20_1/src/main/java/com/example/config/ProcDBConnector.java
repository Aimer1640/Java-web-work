package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("proc")
public class ProcDBConnector implements DBConnector{
    @Override
    public void configure() {
        System.out.println("生产环境");
    }
}
