package com.example.dao;


import com.example.pojo.User;

import java.util.List;

public interface UserDao {

    //添加用户
    int addUser(User user);

    //更新用户信息
    int updateUser(User user);

    //删除用户
    int deleteUserById(Integer id);

    //查询所有学生用户
    List<User> findUserByRoleId(Integer role_id);

    //查询指定id的学生用户
    User findUserById(Integer id);

    //登陆验证
    User login(User user);
}
