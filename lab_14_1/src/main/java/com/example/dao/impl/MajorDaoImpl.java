package com.example.dao.impl;

import com.example.dao.MajorDao;
import com.example.pojo.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("majorDao")
public class MajorDaoImpl implements MajorDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int addMajor(Major major) {
        String sql="insert into tb_major(major_id,major_name,tuition,dept_id) values(?,?,?,?)";
        Object[] addmajor=new Object[]{major.getMajorId(),major.getMajorName(),major.getTuition(),major.getDeptId()};
        int rows=jdbcTemplate.update(sql,addmajor);
        return rows;
    }
    //2040706101 杨艾琳
    @Override
    public int updateMajor(Major major) {
        String sql="update tb_major set major_name=? where major_id=?";
        Object[] updatemajor=new Object[]{major.getMajorName(),major.getMajorId()};
        int rows=jdbcTemplate.update(sql,updatemajor);
        return rows;
    }

    @Override
    public int deleteMajorById(String majorId) {
        String sql="delete from tb_major where major_id=?";
        int rows=jdbcTemplate.update(sql,majorId);
        return rows;
    }

    //批量删除
    @Override
    public int deleteMajorsByIds(String[] ids) {
        String sql="delete from tb_major where major_id in(";
        for (int i=0;i<ids.length;i++) {
            sql+=ids[i]+",";
        }
        sql+=ids[ids.length-1]+")";
        int rows=jdbcTemplate.update(sql);
        return rows;
    }

    //2040706101 杨艾琳
    @Override
    public Major findMajorById(String majorId) {
        String sql="select * from tb_major where major_id=?";
        RowMapper<Major> rowMapper=BeanPropertyRowMapper.newInstance(Major.class);
        Major major=jdbcTemplate.queryForObject(sql,rowMapper,majorId);
        return major;
    }

    @Override
    public List<Major> findAllMajor() {
        String sql="select * from tb_major";
        RowMapper<Major> rowMapper= BeanPropertyRowMapper.newInstance(Major.class);
        List<Major> majorList=jdbcTemplate.query(sql,rowMapper);
        return majorList;
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
