package com.example.service;


import com.example.pojo.Freshman;

import java.util.List;
import java.util.Map;

public interface FreshmanService {
    //登录验证
    public Freshman getFreshmanLogin(String ticketnumber, String id_card);

    //多条件查询新生信息
    public List<Freshman> selectFreshmanByMultiple(Map<String, Object> params);

    //添加新生信息
    public void addFreshman(Freshman f);

    //修改新生信息
    public void updateFreshman(Freshman f);

    //删除新生信息
    public void deleteFreshman(Map<String, Object> param);

    //使用动态SQL中的<foreach>元素遍历指定系的新生信息--array
    public List<Freshman> findFreshmanByDeptIdsAsArray(Integer[] ids);

    //使用动态SQL中的<foreach>元素遍历指定系的新生信息--list
    public List<Freshman> findFreshmanByDeptIdsAsList(List<Integer> ids);
}
