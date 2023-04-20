package com.example.controller;

import com.example.pojo.Freshman;
import com.example.service.FreshmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
@Controller("freshmanController2")
public class FreshmanController2 {
    //自动装配
    @Autowired
    private FreshmanService freshmanService;
    //2040706101 杨艾琳
    //登录验证
    public String getFreshmanLogin(String ticketnumber, String id_card) {
        freshmanService.getFreshmanLogin(ticketnumber,id_card);
        return "success";
    }

    //多条件查询新生信息
    public List<Freshman> selectFreshmanByMultiple(Map<String, Object> params) {
        freshmanService.selectFreshmanByMultiple(params);
//        System.out.println(freshman);
        return null;
    }
    //2040706101 杨艾琳
    //添加新生信息
    public String addFreshman(Freshman f) {
        freshmanService.addFreshman(f);
        return "success";
    }

    //修改新生信息
    public String updateFreshman(Freshman f) {
        freshmanService.updateFreshman(f);
        return "success";
    }

    //删除新生信息
    public String deleteFreshman(Map<String, Object> param) {
        freshmanService.deleteFreshman(param);
        return "success";
    }
    //2040706101 杨艾琳
    //使用动态SQL中的<foreach>元素遍历指定系的新生信息--array
    public List<Freshman> findFreshmanByDeptIdsAsArray(Integer[] ids) {
        freshmanService.findFreshmanByDeptIdsAsArray(ids);
        return null;
    }

    //使用动态SQL中的<foreach>元素遍历指定系的新生信息--list
    public List<Freshman> findFreshmanByDeptIdsAsList(List<Integer> ids) {
        freshmanService.findFreshmanByDeptIdsAsList(ids);
        return null;
    }
}