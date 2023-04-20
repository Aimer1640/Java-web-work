package com.example.dao.impl;

import com.example.dao.TeacherDao;
import com.example.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.List;


/**
 * @author Administrator
 */
@Repository("teacherDao")
public class TeacherDaoImpl implements TeacherDao {
    //2040706101 杨艾琳
    //定义JdbcTemplate属性及其getter和setter方法
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //添加教师
    @Override
    public int addTeacher(Teacher t) {
        //定义SQL语句
        String sql="insert into tb_teacher(job_id,teacher_name,gender,tel,role,dept_id) values(?,?,?,?,?,?)";
        //存放SQL语句的参数
        Object[] insert=new Object[]{t.getJobId(),t.getTeacherName(),t.getGender(),t.getTel(),t.getRole(),t.getDeptId()};
        //执行SQL，获取返回结果
        int flag=jdbcTemplate.update(sql,insert);
        return flag;
    }

    //更新教师信息
    @Override
    public int updateTeacher(Teacher t) {
        //定义SQL语句
        String sql="update tb_teacher set teacher_name=?,gender=?,tel=?,role=?,dept_id=? where job_id=?";
        //存放SQL语句的参数
        Object[] update=new Object[]{t.getTeacherName(),t.getGender(),t.getTel(),t.getRole(),t.getDeptId(),t.getJobId()};
        //执行SQL，获取返回结果
        int flag=jdbcTemplate.update(sql,update);
        return flag;
    }
    //2040706101 杨艾琳
    //删除教师
    @Override
    public int deleteTeacherById(String job_id) {
        //定义SQL语句
        String sql="delete from tb_teacher where job_id=?";
        //执行SQL，获取返回结果
        int flag=jdbcTemplate.update(sql,job_id);
        return flag;
    }

    //根据角色查询所有教师信息
    @Override
    public List<Teacher> findTeacherByRole(int role) {
        String sql="select * from tb_teacher where role=?";
        BeanPropertyRowMapper<Teacher> rowMapper=BeanPropertyRowMapper.newInstance(Teacher.class);
        List<Teacher> teachers= jdbcTemplate.query(sql,rowMapper,role);
        return teachers;

    }
    //2040706101 杨艾琳
    //查询指定工号的教师信息
    @Override
    public Teacher findTeacherById(String job_id) {
        String sql="select * from tb_teacher where job_id=?";
        BeanPropertyRowMapper<Teacher> rowMapper= BeanPropertyRowMapper.newInstance(Teacher.class);
        Teacher teacher=jdbcTemplate.queryForObject(sql,rowMapper,job_id);
        return teacher;
    }

    //根据系别查询所有教师信息
    @Override
    public List<Teacher> findTeacherByDept(Integer deptId){
        //定义SQL语句
        String sql = "select `job_id`  as 'jobId',`teacher_name` AS 'teacherName',gender,tel,role, `dept_id`  as 'deptId' from tb_teacher where dept_id = ?";
        BeanPropertyRowMapper<Teacher> rowMapper = BeanPropertyRowMapper.newInstance(Teacher.class);
        //使用queryForObject方法查询，返回单行记录
        return this.jdbcTemplate.query(sql, rowMapper, deptId);
    }

    //    @Override
//    public List<Teacher> findAllTeachers() {
//        String sql="select * from tb_teacher";
//        BeanPropertyRowMapper<Teacher> rowMapper= BeanPropertyRowMapper.newInstance(Teacher.class);
//        List<Teacher> teachers=jdbcTemplate.query(sql,rowMapper);
//        return teachers;
//    }

}
