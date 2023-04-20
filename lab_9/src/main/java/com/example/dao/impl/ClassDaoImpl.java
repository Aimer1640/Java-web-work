package com.example.dao.impl;

import com.example.dao.ClassDao;
import com.example.pojo.Class;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

//注解
public class ClassDaoImpl implements ClassDao {

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //定义JdbcTemplate属性及其getter和setter方法
    private JdbcTemplate jdbcTemplate;

   //添加注解

    /**
     * 添加系别
     */
    @Override
    public int addClass(Class c) {
        //定义SQL语句
        String sql="insert into tb_class(class_id,class_name,dept_id) values(?,?,?)";
        //存放SQL语句的参数
        Object[] addclass=new Object[]{c.getClass_id(),c.getClass_name(),c.getDept_Id()};
        //执行SQL，获取返回结果
        int rows=jdbcTemplate.update(sql,addclass);
        return rows;
    }
    /**
     * 更新系别数据
     */
    @Override
    public int updateClass(Class c) {
        //定义SQL语句
        
        //存放SQL语句的参数
        
        //执行SQL，获取返回结果
        
        return 0;
    }

    /**
     * 删除系别
     */
    public int deleteClassById(Integer ClassId) {
        //定义SQL语句
        
        //执行SQL，获取返回结果
        
        return 0;
    }
    /**
     * 根据班级名称查询班级
     */
    public List<Class> findClassByName(String ClassName){
        //定义SQL语句

        //使用query()方法查询，返回单行记录

        return null;
    }
    /**
     * 查询某个系的所有班级
     */
    public List<Class> findAllClassByDept(Integer dept_id){
        //定义SQL语句
        

	/*
	* 提供默认实现类 BeanPropertyRowMapper ， javabean属性和表的字段必须一致
	BeanPropertyRowMapper将结果集通过java的反射机制映射到java对象中
	 */
        
        //使用query方法执行查询，并返回一个集合
        return null;
    }

    //查询某个专业的所有班级
    public List<Class> findAllClassByMajor(Integer majorId) {
        //定义SQL语句
        
        //使用query方法执行查询，并返回一个集合
        return null;
    }
}