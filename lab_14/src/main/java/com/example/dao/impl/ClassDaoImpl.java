package com.example.dao.impl;

import com.example.dao.ClassDao;
import com.example.pojo.Class;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("classDao")
public class ClassDaoImpl implements ClassDao {
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
    public int addClass(Class c) {
        //定义SQL语句
        String sql = "insert into tb_class(class_name,class_size,class_surplus,dept_id,major_id,tutor_id,instructor_id,bz) values(?,?,?,?,?,?,?,?)";
        //存放SQL语句的参数
        Object[] params =new Object[]{c.getClassName(),c.getClassSize(),c.getClassSurplus(),c.getDeptId(),c.getMajorId(),c.getTutorId(),c.getInstructorId(),c.getBz()};
        //执行SQL，获取返回结果
        int flag = this.jdbcTemplate.update(sql,params);
        return flag;
    }
    /**
     * 更新系别数据
     */
    @Override
    public int updateClass(Class c) {
        //定义SQL语句
        String sql = "update tb_class set class_name = ?,class_size=?,class_surplus=?,tutor_id=?," +
                "instructor_id=?,bz=? where class_id = ?";
        //存放SQL语句的参数
        Object[] params =new Object[]{c.getClassName(),c.getClassSize(),c.getClassSurplus(),
                c.getTutorId(),c.getInstructorId(),c.getBz(),c.getClassId()};
        //执行SQL，获取返回结果
        int flag = this.jdbcTemplate.update(sql, params);
        return flag;
    }

    //根据id查询某个班级
    @Override
    public Class findClassById(Integer classId){
        //定义SQL语句
        String sql  = "select * from tb_class where class_id = ?";
        RowMapper<Class> rowMapper = BeanPropertyRowMapper
                .newInstance(Class.class);
        //执行SQL，获取返回结果
        return this.jdbcTemplate.queryForObject(sql,rowMapper,classId);
    }

    /**
     * 删除班级
     */
    @Override
    public int deleteClassById(Integer classId) {
        //定义SQL语句
        String sql  = "delete from tb_class where class_id = ?";
        //执行SQL，获取返回结果
        int flag = this.jdbcTemplate.update(sql, classId);
        return flag;
    }
    /**
     * 根据班级名称查询班级
     */
    @Override
    public List<Class> findClassByName(String className){
        //定义SQL语句
        String sql = "select * from tb_class where class_name like concat('%',?,'%')";
        RowMapper<Class> rowMapper = BeanPropertyRowMapper
                .newInstance(Class.class);
        //使用queryForObject方法查询，返回单行记录
        return this.jdbcTemplate.query(sql, rowMapper, className);
    }
    /**
     * 查询某个系的所有班级
     */
    @Override
    public List<Class> findAllClassByDept(Integer dept_id){
        //定义SQL语句
        String sql = "select * from tb_class where dept_id=?";
		/*
		 * 提供默认实现类 BeanPropertyRowMapper ， javabean属性和表的字段必须一致
		   BeanPropertyRowMapper将结果集通过java的反射机制映射到java对象中
		 */
        RowMapper<Class> rowMapper = BeanPropertyRowMapper
                .newInstance(Class.class);
        //使用query方法执行查询，并返回一个集合
        return this.jdbcTemplate.query(sql, rowMapper,dept_id);
    }

    //查询某个专业的所有班级
    @Override
    public List<Class> findAllClassByMajor(Integer majorId) {
        //定义SQL语句
        String sql = "select * from tb_class where dept_id=?";
        RowMapper<Class> rowMapper = BeanPropertyRowMapper
                .newInstance(Class.class);
        //使用query方法执行查询，并返回一个集合
        return this.jdbcTemplate.query(sql, rowMapper,majorId);
    }
}