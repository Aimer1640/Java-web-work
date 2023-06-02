package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    //登陆验证
    @Select("select * from tb_user where account=#{account} and password=#{password} and role_id=#{roleId}")
    User login(User user);
}
