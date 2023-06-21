package com.example.config;

import com.example.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

//2040706101 杨艾琳
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private DataSource dataSource;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,RememberMeServices rememberMeServices) throws Exception{
        http.
                authorizeHttpRequests(
                (authorize)->authorize
                        .requestMatchers("/amazeui/**","/css/**","/js/**","/images/**","/login").permitAll()
                        .requestMatchers("/officer/**").hasAuthority("ADMIN")
                        .requestMatchers("/officer/**","/freshman/**").hasAuthority("TEACHER")
                        .requestMatchers("/officer/**").hasAuthority("ROLE_STUDENT")
                        .anyRequest().authenticated()
//                        .and().headers().frameOptions().sameOrigin()
        )
                .headers(headers->headers
                        .frameOptions(frameOptionsConfig -> frameOptionsConfig
                                .sameOrigin()
                        )
                )
                .httpBasic(withDefaults())
                .formLogin(
                        form->form
                                .loginPage("/login")
                                .permitAll()
                )
                .logout(form->form
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                )
                .rememberMe((rememberMe)->rememberMe
                        .rememberMeServices(rememberMeServices)
                        .tokenRepository(jdbcTokenRepository())
               )
        ;

        return http.build();
    }

    @Bean
    UserDetailsServiceImpl userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    RememberMeServices rememberMeServices(UserDetailsService userDetailsService){
        TokenBasedRememberMeServices.RememberMeTokenAlgorithm encodingAlgorithm= TokenBasedRememberMeServices.RememberMeTokenAlgorithm.SHA256;
        TokenBasedRememberMeServices rememberMe=new TokenBasedRememberMeServices("remember-me",userDetailsService,encodingAlgorithm);
        rememberMe.setMatchingAlgorithm(TokenBasedRememberMeServices.RememberMeTokenAlgorithm.MD5);
        return rememberMe;
    }

    @Bean
    JdbcTokenRepositoryImpl jdbcTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository=new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }
}
