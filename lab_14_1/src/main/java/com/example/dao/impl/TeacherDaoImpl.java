package com.example.dao.impl;

import com.example.dao.TeacherDao;
import com.example.pojo.Teacher;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("teaDao")
public class TeacherDaoImpl implements TeacherDao {
    //定义JdbcTemplate属性及其getter和setter方法
    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //添加教师
    public int addTeacher(Teacher t) {

        //定义SQL语句
        String sql = "insert into tb_teacher(job_id,teacher_name,gender,tel,role,dept_id) values(?,?,?,?,?,?)";
        //存放SQL语句的参数
        Object[] params =new Object[]{t.getJobId(),t.getTeacherName(),t.getGender(),t.getTel(),t.getRole(),t.getDeptId()};
        //执行SQL，获取返回结果
        int flag = this.jdbcTemplate.update(sql,params);
        return flag;
    }

    //更新教师信息
    public int updateTeacher(Teacher t) {
        //定义SQL语句
        String sql = "update tb_teacher set teacher_name=?,gender=?,tel=?,role=?,dept_id=? where job_id=?";
        //存放SQL语句的参数
        Object[] params =new Object[]{t.getTeacherName(),t.getGender(),t.getTel(),t.getRole(),t.getDeptId(),t.getJobId(),};
        //执行SQL，获取返回结果
        int flag = this.jdbcTemplate.update(sql,params);
        return flag;
    }

    //删除教师
    public int deleteTeacherById(Integer job_id) {
        //定义SQL语句
        String sql  = "delete from tb_teacher where job_id = ?";
        //执行SQL，获取返回结果
        int flag = this.jdbcTemplate.update(sql, job_id);
        return flag;
    }

    //根据角色查询所有教师信息
    public List<Teacher> findTeacherByRole(Integer role) {
        //定义SQL语句
        String sql = "select `job_id`  as 'jobId',`teacher_name` AS 'teacherName',gender,tel,role,`dept_id`  as 'deptId' from tb_teacher where role = ?";
        RowMapper<Teacher> rowMapper = BeanPropertyRowMapper
                .newInstance(Teacher.class);
        //使用queryForObject方法查询，返回单行记录
        return this.jdbcTemplate.query(sql, rowMapper, role);
    }

    //查询指定工号的教师信息
    public Teacher findTeacherById(Integer job_id) {
        //定义SQL语句
        String sql = "select `job_id`  as 'jobId',`teacher_name` AS 'teacherName',gender,tel,role, `dept_id`  as 'deptId' from tb_teacher where job_id = ?";
        RowMapper<Teacher> rowMapper = BeanPropertyRowMapper
                .newInstance(Teacher.class);
        //使用queryForObject方法查询，返回单行记录
        return this.jdbcTemplate.queryForObject(sql, rowMapper, job_id);
    }

    //根据系别查询所有教师信息
    public List<Teacher> findTeacherByDept(Integer deptId){
        //定义SQL语句
        String sql = "select `job_id`  as 'jobId',`teacher_name` AS 'teacherName',gender,tel,role, `dept_id`  as 'deptId' from tb_teacher where dept_id = ?";
        RowMapper<Teacher> rowMapper = BeanPropertyRowMapper
                .newInstance(Teacher.class);
        //使用queryForObject方法查询，返回单行记录
        return this.jdbcTemplate.query(sql, rowMapper, deptId);

    }
}
