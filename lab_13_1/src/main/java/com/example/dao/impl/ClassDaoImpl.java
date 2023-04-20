package com.example.dao.impl;

import com.example.dao.ClassDao;
import com.example.pojo.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("classDao")
public class ClassDaoImpl implements ClassDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //2040706101 杨艾琳
    @Override
    public int addClass(Class c) {
        String sql="insert into tb_class(class_id,class_name,class_size,class_surplus,major_id) values(?,?,?,?,?)";
        Object[] addclass=new Object[]{c.getClassId(),c.getClassName(),c.getClassSize(),c.getClassSurplus(),c.getMajorId()};
        int rows=jdbcTemplate.update(sql,addclass);
        return rows;
    }
    /**
     * 更新系别数据
     */
    @Override
    public int updateClass(Class c) {
        //定义SQL语句
        String sql="update tb_class set class_name=?,class_size=?,class_surplus=?,major_id=? where class_id=?";
        //存放SQL语句的参数
        Object[] updateclass=new Object[]{c.getClassName(),c.getClassSize(),c.getClassSurplus(),c.getMajorId(),c.getClassId()};
        int rows=jdbcTemplate.update(sql,updateclass);
        //执行SQL，获取返回结果
        return rows;
    }
    /**
     * 删除系别
     */
    @Override
    public int deleteClassById(String ClassId) {
        String sql="delete from tb_class where class_id=?";
        int rows=jdbcTemplate.update(sql,ClassId);
        return rows;
    }
    //2040706101 杨艾琳
    @Override
    public Class findClassById(Integer classId) {
        String sql="select * from tb_class where class_id=?";
        RowMapper<Class> rowMapper=BeanPropertyRowMapper.newInstance(Class.class);
        Class classes=jdbcTemplate.queryForObject(sql,rowMapper,classId);
        return classes;
    }

    @Override
    public List<Class> findAllClasses() {
        String sql="select * from tb_class";
        RowMapper<Class> rowMapper=BeanPropertyRowMapper.newInstance(Class.class);
        List<Class> classList=jdbcTemplate.query(sql,rowMapper);
        return classList;
    }
}