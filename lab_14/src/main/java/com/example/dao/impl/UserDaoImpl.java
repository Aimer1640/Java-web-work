package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.pojo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean login(User user) {
        String sql = "select * from tb_user where account=? and password=?";
        RowMapper rowMapper = BeanPropertyRowMapper.newInstance(User.class);
        Object[] params = new Object[]{user.getAccount(), user.getPassword()};
        try {
            User userResult = (User) jdbcTemplate.queryForObject(sql, rowMapper, params);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
