package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * FROM tb_user WHERE account = #{username}" + "and password = #{password}")
    public User findUser(String s, String username, String password);

    User findUser(String username, String password);
//    User findUser(String username, String password, String role);

}
