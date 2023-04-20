package com.example.dao.impl;

import com.example.dao.MajorDao;
import com.example.pojo.Major;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class MajorDaoImpl extends SqlSessionDaoSupport implements MajorDao {
    @Override
    public int addMajor(Major major) {
        SqlSession session=this.getSqlSession();
        int rows=session.update("com.example.mapper.MajorMapper.addMajor",major);
        return rows;
    }

    @Override
    public int updateMajor(Major major) {
        SqlSession session=this.getSqlSession();
        int rows=session.update("com.example.mapper.MajorMapper.updateMajor",major);
        return rows;
    }
//2040706101 杨艾琳
    @Override
    public int deleteMajorById(String majorId) {
        SqlSession session=this.getSqlSession();
        int rows=session.update("com.example.mapper.MajorMapper.deleteMajorById",majorId);
        return rows;
    }

    @Override
    public Major findMajorById(String majorId) {
        SqlSession session=this.getSqlSession();
        Major major=session.selectOne("com.example.mapper.MajorMapper.findMajorById",majorId);
        return major;
    }
    //2040706101 杨艾琳
    @Override
    public List<Major> findAllMajor() {
        SqlSession session=this.getSqlSession();
        List<Major> majorList=session.selectList("com.example.mapper.MajorMapper.findAllMajor");
        return majorList;
    }
}
