package com.example.dao.impl;

import com.example.dao.DeptDao;
import com.example.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
//2040706101 杨艾琳
@Repository("deptDao")
public class DeptDaoImpl implements DeptDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Dept> findAllDepts() {
        String sql="select * from tb_dept";
        RowMapper<Dept> rowMapper= BeanPropertyRowMapper.newInstance(Dept.class);
        List<Dept> depts=jdbcTemplate.query(sql,rowMapper);
        return depts;
    }

    @Override
        public Dept findDeptById(Integer deptId) {
            String sql="select * from tb_dept where dept_id=?";
            RowMapper<Dept> rowMapper=BeanPropertyRowMapper.newInstance(Dept.class);
            Dept dept=jdbcTemplate.queryForObject(sql,rowMapper,deptId);
            return dept;
    }
    //2040706101 杨艾琳
    @Override
    public int addDept(Dept dept) {
        String sql="insert into tb_dept(dept_id,dept_name) values(?,?)";
        Object[] adddept=new Object[]{dept.getDeptId(),dept.getDeptName()};
        int rows=jdbcTemplate.update(sql,adddept);
        return rows;
    }

    @Override
    public int updateDept(Dept dept) {
        String sql="update tb_dept set dept_name=? where dept_id=?";
        Object[] updatedept=new Object[]{dept.getDeptName(),dept.getDeptId()};
        int rows=jdbcTemplate.update(sql,updatedept);
        return rows;
    }
    //2040706101 杨艾琳
    @Override
    public int deleteDeptById(Integer id) {
        String sql="delete from tb_dept where dept_id=?";
        int rows=jdbcTemplate.update(sql,id);
        return rows;
    }
}
