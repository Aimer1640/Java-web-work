package com.example.dao;

import com.example.dao.ClassDao;
import com.example.pojo.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("classDao")
//注解
public class ClassDaoImpl implements ClassDao {

    //定义JdbcTemplate属性及其getter和setter方法
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
//2040706101 杨艾琳

    //2040706101 杨艾琳
    @Override
    public int addClass(Class c) {
        String sql="insert into tb_class(class_id,class_name,class_size,class_surplus,major_id) values(?,?,?,?,?)";
        //存放SQL语句的参数
        Object[] addclass=new Object[]{c.getClassId(),c.getClassName(),c.getClassSize(),c.getClassSurplus(),c.getMajorId()};
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
    public int deleteClassById(Integer ClassId) {
        //定义SQL语句
        String sql="delete from tb_class where class_id=?";
        //执行SQL，获取返回结果
        int rows=jdbcTemplate.update(sql,ClassId);
        return rows;

    }

    @Override
    public Class findClassById(Integer classId) {
        String sql="select * from tb_class where class_id=?";
        //执行SQL，获取返回结果
        RowMapper<Class> rowMapper=BeanPropertyRowMapper.newInstance(Class.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,classId);
    }

    @Override
    public List<Class> findAllClasses() {
        String sql="select * from tb_class";
        RowMapper<Class> rowMapper=BeanPropertyRowMapper.newInstance(Class.class);
        List<Class> classList=jdbcTemplate.query(sql,rowMapper);
        return classList;
    }

    /**
     * 根据班级名称查询班级
     */
//    @Override
//    public List<Class> findClassByName(String class_name){
//        //定义SQL语句
//        String sql="select * from tb_class where class_name=?";
//        //使用query()方法查询，返回单行记录
//        BeanPropertyRowMapper<Class> rowMapper= BeanPropertyRowMapper.newInstance(Class.class);
//        List cl= jdbcTemplate.query(sql,rowMapper,class_name);
//        return cl;
//    }
//
//    /**
//     * 查询某个系的所有班级
//     */
//    @Override
//    public List<Class> findAllClassByDept(Integer dept_id){
//        //定义SQL语句
//        String sql="select * from tb_class where dept_id=?";
//        //使用query()方法查询，返回单行记录
//        BeanPropertyRowMapper<Class> rowMapper= BeanPropertyRowMapper.newInstance(Class.class);
//        List cl= jdbcTemplate.query(sql,rowMapper,dept_id);
//        return cl;
//    }
//    //2040706101 杨艾琳
//    //查询某个专业的所有班级
//    @Override
//    public List<Class> findAllClassByMajor(Integer major_id) {
//        //定义SQL语句
//        String sql="select * from tb_class where major_id=?";
//        //使用query方法执行查询，并返回一个集合
//        BeanPropertyRowMapper<Class> rowMapper= BeanPropertyRowMapper.newInstance(Class.class);
//        List cl= jdbcTemplate.query(sql,rowMapper,major_id);
//        return cl;
//    }
}