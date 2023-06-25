package com.example.mapper;


import com.example.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper{
    @Select("SELECT * FROM tb_user WHERE account = #{username}" + "and password = #{password}" + "and role_id = #{role}")
    User findUser(String username, String password, String role);
}
