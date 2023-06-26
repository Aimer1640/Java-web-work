package com.example.mapper;

import com.example.pojo.Persons;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMapper {
    @Select("SELECT * FROM tb_user WHERE account = #{username}" + "and password = #{password}" + "and role_id = #{role}")
    Persons findUser(String username, String password, String role);
}
