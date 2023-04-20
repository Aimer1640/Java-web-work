package com.example.dao;

import com.example.pojo.Freshman;


import java.util.List;

public interface FreshmanDao {

    //更新班级
    public int updateFreshman(Freshman freshman);

    //根据id查询新生
    Freshman findFreshmanByticketNumber(String ticketNumber);


}
