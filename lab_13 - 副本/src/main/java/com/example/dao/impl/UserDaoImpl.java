package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User login(User user) {
        String sql="select * from tb_user where account=? and password=?";
        Object[] params=new Object[]{
                user.getAccount(),
                user.getPassword()
        };
        RowMapper<User> rowMapper= BeanPropertyRowMapper.newInstance(User.class);
        User user1=jdbcTemplate.queryForObject(sql,rowMapper,params);
        return user1;
//        try {
//            User user1=jdbcTemplate.queryForObject(sql,rowMapper,params);
//            return user1;
//        }catch (EmptyResultDataAccessException e){
//            return null;
//        }
    }
}
