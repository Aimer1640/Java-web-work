package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    //2040706101 杨艾琳
    @Bean
    UserDetailsManager users(DataSource dataSource){
        JdbcUserDetailsManager users=new JdbcUserDetailsManager(dataSource);
        return users;
    }

}
