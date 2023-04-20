package com.example.dao.impl;

import com.example.dao.MajorDao;
import com.example.pojo.Major;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.List;

@Repository("majorDao")
public class MajorDaoImpl implements MajorDao {
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
    public int addMajor(Major major){
        //定义SQL语句
        String sql = "insert into tb_major(major_id,major_name,tuition,dept_id) values(?,?,?,?)";
        //存放SQL语句的参数
        Object[] params =new Object[]{major.getMajorId(),major.getMajorName(),major.getTuition(),major.getDeptId()};
        //执行SQL，获取返回结果
        int flag = this.jdbcTemplate.update(sql,params);
        return flag;
    }
    /**
     * 更新系别数据
     */
    public int updateMajor(Major major){
       //定义SQL语句
        String sql = "update tb_major set major_name='"+major.getMajorName()+"',tuition="+major.getTuition()+" where major_id = '"+ major.getMajorId()+"'";
        //执行SQL，获取返回结果
        int flag = this.jdbcTemplate.update(sql);
        System.out.println(sql);
        return flag;
    }
    /**
     * 删除系别
     */
    public int deleteMajorById(String majorId) {
        //定义SQL语句
        String sql  = "delete from tb_major where major_id = ?";
        //执行SQL，获取返回结果
        int flag = this.jdbcTemplate.update(sql, majorId);
        return flag;
    }
    /**
     * 根据id查询系别
     */
    public Major findMajorById(String majorId) {
        //定义SQL语句
        String sql = "select `major_id` AS 'majorId' ,`major_name` AS 'majorName',tuition,`dept_id`  as 'deptId'  from tb_major where major_id = ?";
        RowMapper<Major> rowMapper = BeanPropertyRowMapper
                .newInstance(Major.class);
        //使用queryForObject方法查询，返回单行记录
        return this.jdbcTemplate.queryForObject(sql, rowMapper, majorId);
    }
    /**
     * 查询所有系别
     */
    public List<Major> findAllMajor() {
        //定义SQL语句
        String sql = "select `major_id` AS 'majorId' ,`major_name` AS 'majorName',tuition,`dept_id`  as 'deptId' from tb_major";
		/*
		 * 提供默认实现类 BeanPropertyRowMapper ， javabean属性和表的字段必须一致
		   BeanPropertyRowMapper将结果集通过java的反射机制映射到java对象中
		 */
        RowMapper<Major> rowMapper = BeanPropertyRowMapper
                .newInstance(Major.class);
        //使用query方法执行查询，并返回一个集合
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    /**
     * 根据id批量删除系别
     */
    public void bathDeleteMajor(String []majorIds){
        //1.客户端复选框传递过来一个数组majorIds,专业的ID
        // 2.声明sql数组
        String [] sql =new String [majorIds.length+1];
        //3.新数据添加到中间表,通过major_id删除表中数据
        // sql[0] = "delete from role_link_menu where fk_role_id=200";
        for (int i=0;i<majorIds.length;i++) {
            sql[i+1]="delete from tb_major where major_id='"+majorIds[i]+"'";
        }
        jdbcTemplate.batchUpdate(sql);
    }

    //根据系别查询专业
    public List<Major> findMajorByDeptId(Integer dept_id){
        //定义SQL语句
        String sql = "select `major_id` AS 'majorId' ,`major_name` AS 'majorName',tuition, `dept_id` as 'deptId' from tb_major where dept_id=?";
		/*
		 * 提供默认实现类 BeanPropertyRowMapper ， javabean属性和表的字段必须一致
		   BeanPropertyRowMapper将结果集通过java的反射机制映射到java对象中
		 */
        RowMapper<Major> rowMapper = BeanPropertyRowMapper
                .newInstance(Major.class);
        //使用query方法执行查询，并返回一个集合
        return this.jdbcTemplate.query(sql, rowMapper,dept_id);
    }
}