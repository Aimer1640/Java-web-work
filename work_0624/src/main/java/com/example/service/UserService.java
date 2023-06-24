package com.example.service;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserService {
    public User finduser(@Param("username")String username, @Param("password")String password);
}
