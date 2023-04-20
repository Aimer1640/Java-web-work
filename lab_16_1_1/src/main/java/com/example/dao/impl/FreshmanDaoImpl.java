package com.example.dao.impl;

import com.example.dao.FreshmanDao;
import com.example.pojo.Freshman;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("freshmanDao")
public class FreshmanDaoImpl implements FreshmanDao {

    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //2040706101 杨艾琳
    @Override
    public int updateFreshman(Freshman freshman) {
        String sql = "update tb_freshman set name = ?,sex=?,age=? where id_card = ?";
        //存放SQL语句的参数
        Object[] params =new Object[]{freshman.getName(),freshman.getSex(),freshman.getAge(),freshman.getIdCard()};

        //执行SQL，获取返回结果
        int flag = this.jdbcTemplate.update(sql, params);
        return flag;
    }

    @Override
    public Freshman findFreshmanByticketNumber(String ticketNumber) {
        String sql  = "select * from tb_freshman where ticketNumber = ?";
        RowMapper<Freshman> rowMapper = BeanPropertyRowMapper
                .newInstance(Freshman.class);
        //执行SQL，获取返回结果
        return this.jdbcTemplate.queryForObject(sql,rowMapper,ticketNumber);
    }
}
