package com.example;

import com.example.pojo.Class;
import com.example.pojo.Dept;
import com.example.repository.ClassRepository;
import com.example.repository.DeptRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

@SpringBootTest
class Lab22ApplicationTests {
    //2040706101 杨艾琳
    @Autowired
    private ClassRepository classRepository;
    private DeptRespository deptRespository;
    @Test
    void addClass(){
        Class c=new Class();
        c.setClassId(100);
        c.setClassName("测试班级");
        c.setClassSize(60);
        classRepository.save(c);
    }
    @Test
    void addDeptTest(){
        Dept dept=new Dept();
        dept.setDeptId(4070);
        dept.setDeptName("testdetp1");
        deptRespository.save(dept);
    }
//
//    @Test
//    void addMajorTest(){
//        Major major=new Major();
//        major.setMajorId("412");
//        major.setMajorName("计算机");
//        majorRepository.save(major);
//    }
//    @Test
//    void updateDeptTest(){
//        Dept dept=new Dept();
//        dept.setDeptId(4070);
//        dept.setDeptName("testdetp2");
//        deptRespository.save(dept);
//    }
//
//    @Test
//    void delDeptTest(){
//        deptRespository.deleteById(4070);
//    }
//
//    @Test
//    void findAllDeptTest(){
//        List<Dept> depts=deptRespository.findAll();
//        for (Dept dept:depts){
//            System.out.println(dept);
//        }
//    }
//
//    @Test
//    void findDeptByDeptNameContainsTest(){
//        List<Dept> depts=deptRespository.findDeptByDeptNameContains("test");
//        for (Dept dept:depts){
//            System.out.println(dept);
//        }
//    }
//
//    @Test
//    void deleteDeptTest(){
//        deptRespository.deleteDept(4072);
//    }
//
//    @Test
//    void exampleText(){
//        Dept dept=new Dept();
//        dept.setDeptName("te");
//        ExampleMatcher exampleMatcher=ExampleMatcher.matching()
//                .withMatcher("deptName",startsWith());
//        Example<Dept> example=Example.of(dept,exampleMatcher);
//        List<Dept> depts=deptRespository.findAll(example);
//        for (Dept d:depts){
//            System.out.println(d);
//        }
//    }
//
//
//    @Test
//    void findMajorsByMajorNameContainsAndDeptId(){
//        List<Major> major=majorRepository.findMajorsByMajorNameContainsAndDeptId("计算机");
//        for (Major m:major){
//            System.out.println("专业ID：" + m.getMajorId());
//            System.out.println("专业名称：" + m.getMajorName());
//
//            //获取关联的系部信息
//            Dept dept = m.getDept();
//            System.out.println("系部ID：" + dept.getDeptId());
//            System.out.println("系部名称：" + dept.getDeptName());
//            System.out.println("-------------------");
//
//            System.out.println(m);
//        }
//    }

    @Test
    void contextLoads() {
    }

}
