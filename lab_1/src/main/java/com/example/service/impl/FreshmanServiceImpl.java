package com.example.service.impl;

import com.example.mapper.FreshmanMapper;
import com.example.pojo.Freshman;
import com.example.service.FreshmanService;
import com.example.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class FreshmanServiceImpl implements FreshmanService {
    //查询所有新生信息 返回新生集合
    //2040706101 杨艾琳
    @Override
    public List<Freshman> findAll() {
        SqlSession session= MybatisUtils.getSession();
        FreshmanMapper freshmanMapper=session.getMapper(FreshmanMapper.class);
        List<Freshman> allFreshmans=freshmanMapper.findAllFreshmans();
        return allFreshmans;
    }

    @Override
    public Integer addFreshman(Freshman freshman){
        SqlSession session=MybatisUtils.getSession();
        FreshmanMapper freshmanMapper=session.getMapper(FreshmanMapper.class);
        Integer rows=freshmanMapper.addFreshman(freshman);
        session.commit();
        return rows;
    }
    //2040706101 杨艾琳
    @Override
    public Integer deleteFreshman(Map<String, Object> freshman) {
        SqlSession session =MybatisUtils.getSession();
        FreshmanMapper freshmanMapper=session.getMapper(FreshmanMapper.class);
        Integer rows=freshmanMapper.deleteFreshman((Map<String, Object>) freshman);
        session.commit();
        return rows;
    }

    @Override
    public Integer updateFreshman(Freshman freshman) {
        SqlSession session =MybatisUtils.getSession();
        FreshmanMapper freshmanMapper=session.getMapper(FreshmanMapper.class);
        Integer rows=freshmanMapper.updateFreshman(freshman);
        session.commit();
        return rows;
    }
}
