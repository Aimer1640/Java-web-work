package com.example;

import com.example.mapper.DeptMapper;
import com.example.pojo.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Lab212ApplicationTests {

    @Autowired
    private DeptMapper deptMapper;

    @Test
    void contextLoads() {

    }

    @Test
    void addDept(){
        Dept dept=new Dept();
        dept.setDeptId(4072);
        dept.setDeptName("test");

        int rows=deptMapper.insert(dept);
        if (rows>0){
            System.out.println("添加成功");
        }
        else {
            System.out.println("添加失败");
        }
    }

    @Test
    void updateByIdTest(){
        Dept dept=new Dept();
        dept.setDeptId(4073);
        dept.setDeptName("test");

        int rows=deptMapper.insert(dept);
//        Dept dept=new Dept();
//        dept.setDeptId(4072);
//        dept.setDeptName("newtest");
//        int rows=deptMapper.updateById(dept);
        if (rows>0){
            System.out.println("更新成功");
        }
        else {
            System.out.println("更新失败");
        }
    }

    @Test
    void deleteDeptTest(){
        Dept dept=new Dept();
        dept.setDeptId(4074);
        dept.setDeptName("test");

        int rows=deptMapper.insert(dept);
//        Dept d=new Dept();
//        d.setDeptId(4073);
//        deptMapper.deleteById(d);
//        int rows=deptMapper.deleteById(d);
        if (rows>0){
            System.out.println("删除成功");
        }
        else {
            System.out.println("删除失败");
        }
    }

    @Test
    void findAllDept(){
        List<Dept> allDepts=new ArrayList<>();
        allDepts=deptMapper.selectList(null);
        if (allDepts!=null){
            for (Dept d:allDepts){
                System.out.println(d);
            }
        }
    }

}
