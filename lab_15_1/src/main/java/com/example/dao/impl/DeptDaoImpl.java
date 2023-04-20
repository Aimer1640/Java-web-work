package com.example.dao.impl;

import com.example.dao.DeptDao;
import com.example.pojo.Dept;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("deptDao")
public class DeptDaoImpl implements DeptDao {
    //定义JdbcTemplate属性及其getter和setter方法
    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    /**
     * 添加系别
     */
    @Override
    public int addDept(Integer deptId, String deptName) {
        //定义SQL语句
        String sql = "insert into tb_dept(dept_id,dept_name) values(?,?)";
        //存放SQL语句的参数
        Object[] params =new Object[]{deptId,deptName};
        //执行SQL，获取返回结果
        int flag = this.jdbcTemplate.update(sql,params);
        return flag;
    }
    /**
     * 更新系别数据
     */
    @Override
    public int updateDept(Integer deptId, String deptName) {
        //定义SQL语句
        String sql = "update tb_dept set dept_name = ? where dept_id = ?";
        //存放SQL语句的参数
        Object[] params =new Object[]{deptName,deptId};
        //执行SQL，获取返回结果
        int flag = this.jdbcTemplate.update(sql, params);
        return flag;
    }
    /**
     * 删除系别
     */
    @Override
    public int deleteDeptById(Integer deptId) {
        //定义SQL语句
        String sql  = "delete from tb_dept where dept_id = ?";
        //执行SQL，获取返回结果
        int flag = this.jdbcTemplate.update(sql, deptId);
        return flag;
    }
    /**
     * 根据id查询系别
     */ //定义SQL语句

    @Override
    public Dept findDeptById(Integer deptId) {
        //定义SQL语句
        String sql = "select `dept_id` AS 'deptId' ,`dept_name` AS 'deptname'  from tb_dept where dept_id = ?";
        RowMapper<Dept> rowMapper = BeanPropertyRowMapper
                .newInstance(Dept.class);
        //使用queryForObject方法查询，返回单行记录
        return this.jdbcTemplate.queryForObject(sql, rowMapper, deptId);
    }
    /**
     * 查询所有系别
     */
    @Override
    public List<Dept> findAllDept() {
        //定义SQL语句
        String sql = "select `dept_id` AS 'deptId' ,`dept_name` AS 'deptname' from tb_dept";
		/*
		 * 提供默认实现类 BeanPropertyRowMapper ， javabean属性和表的字段必须一致
		   BeanPropertyRowMapper将结果集通过java的反射机制映射到java对象中
		 */
        RowMapper<Dept> rowMapper = BeanPropertyRowMapper
                .newInstance(Dept.class);
        //使用query方法执行查询，并返回一个集合
        return this.jdbcTemplate.query(sql, rowMapper);
    }
}