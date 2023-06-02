package com.example;

import com.example.mapper.FreshmanMapper;
import com.example.pojo.Freshman;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Lab211ApplicationTests {
    @Autowired
    private FreshmanMapper freshmanMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void addFreshman() throws ParseException {
        Freshman f=new Freshman();
        f.setTicketNumber("2040706101");
        f.setIdCard("1234567");
        f.setName("yal");
        f.setSex(0);
        f.setAge(20);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        try{
            f.setBirthday(sdf.parse("2002-04-12"));
        }catch (ParseException e){
            throw new RuntimeException(e);
        }
        int rows=freshmanMapper.addFreshman(f);
        if (rows>0)
            System.out.println("注册成功");
        else
            System.out.println("注册失败");
    }

    @Test
    void findAllFreshman(){
        List<Freshman> allFreshmans=new ArrayList<>();
        allFreshmans=freshmanMapper.getAllFreshmans();
        if (allFreshmans!=null){
            for (Freshman f:allFreshmans){
                System.out.println(f);
            }
        }
    }

    @Test
    void updateFreshman(){
        Freshman f=new Freshman();
        f.setTicketNumber("2040706101");
        f.setName("yal01");
        f.setSex(1);
        f.setAge(21);
        int rows=freshmanMapper.updateFreshman(f);
        if (rows>0)
            System.out.println("修改成功");
        else
            System.out.println("修改失败");
    }


    @Test
    void findFreshmanTest(){
        List<Freshman> allFreshmans=new ArrayList<>();
        Freshman params=new Freshman();
//        params.setTicketNumber("2040706101");
        allFreshmans=freshmanMapper.findFreshmanByConditions1(params);
        if (allFreshmans!=null){
            for (Freshman f:allFreshmans){
                System.out.println(f);
            }
        }
    }

    @Test
    //删除新生
    public void deleteFreshmanTest(){
        Freshman f=new Freshman();
        f.setTicketNumber("2040706102");
        int rows=freshmanMapper.deleteFreshman(f);
        if (rows>0){
            System.out.println("删除成功");
        }
        else {
            System.out.println("删除失败");
        }
    }

}
