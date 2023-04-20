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
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    public int addMajor(Major major) {
        String sql="insert into tb_major(major_id,major_name,tuition) values(?,?,?)";
        Object[] params=new Object[]{major.getMajorId(),major.getMajorName(),major.getTuition()};
        return jdbcTemplate.update(sql,params);
    }

    @Override
    public List<Major> findAllMajors() {
        String sql="select * from tb_major";
        RowMapper<Major> rowMapper= BeanPropertyRowMapper.newInstance(Major.class);
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public Major findMajorByMajorId(String majorId) {
        String sql="select * from tb_major where major_id=?";
        RowMapper<Major> rowMapper= BeanPropertyRowMapper.newInstance(Major.class);
        Major major=jdbcTemplate.queryForObject(sql,rowMapper,majorId);
        return major;
    }

    @Override
    public int updateMajor(Major major) {
        String sql="update tb_major set major_name=?,tuition=? where major_id=?";
        Object[] params=new Object[]{major.getMajorName(),major.getTuition(),major.getMajorId()};
        int rows=jdbcTemplate.update(sql,params);
        return rows;
    }

    @Override
    public int deleteMajorByMajorId(String majorId) {
        String sql="delete from tb_major  where major_id=?";
        int rows=jdbcTemplate.update(sql,majorId);
        return rows;
    }

    public int deleteMajorsByIds(String[] id){
        String  sql="delete from tb_major  where major_id in (";
        for (int i=0;i<id.length-1;i++){
            sql=sql+id[i]+",";
        }
        sql+=id[id.length-1]+")";

        System.out.println(sql);
        int rows=jdbcTemplate.update(sql);

        return rows;
    }

    @Override
    public List<Major> findMajorsByDeptId(Integer deptId) {
        System.out.println("系部："+deptId);
        String sql="select * from tb_major where dept_id=?";
        RowMapper<Major> rowMapper= BeanPropertyRowMapper.newInstance(Major.class);
        List<Major> majors=jdbcTemplate.query(sql,rowMapper,deptId);
        System.out.println(majors);
        return majors;
    }
}
