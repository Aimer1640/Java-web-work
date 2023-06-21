package com.example.mapper;

import com.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    void login(User user) {
        List<User> users= (List<User>) userMapper.login(user);
        users.forEach(System.out::println);
    }
}