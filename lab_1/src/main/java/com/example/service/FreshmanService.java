package com.example.service;

import com.example.pojo.Freshman;

import java.util.List;
import java.util.Map;

public interface FreshmanService {
    //2040706101 杨艾琳
    public List<Freshman> findAll();

    public Integer addFreshman(Freshman freshman);

    public Integer deleteFreshman(Map<String, Object> param);

    public Integer updateFreshman(Freshman freshman);
}
