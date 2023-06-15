package com.example.config;

import com.example.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

//2040706101 杨艾琳
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.
                authorizeHttpRequests(
                (authorize)->authorize
                        .requestMatchers("/css/**","/js/**","/images/**","/login").permitAll()
                        .anyRequest().authenticated()
        )
                .httpBasic(withDefaults())
                .formLogin(
                        form->form
                                .loginPage("/login")
                                .permitAll()
                );
        return http.build();
    }

    @Bean
    UserDetailsServiceImpl userDetailsService(){
        return new UserDetailsServiceImpl();
    }
}
