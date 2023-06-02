package com.example;

import com.example.dao.MajorDao;
import com.example.pojo.Major;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
@SpringBootTest

public class JdbcTest {
    @Autowired
    private MajorDao majorDao;
    //2040706101 杨艾琳
    @Test
    public void findAllMajorTest(){
        List<Major> majors=majorDao.findAllMajor();
        for (Major m:majors){
            System.out.println(m);
        }
    }

    @Test
    public void addMajorTest(){
        Major major=new Major();
        major.setMajorId("414");
        major.setMajorName("测试专业1");
        major.setTuition(26000);
        major.setDeptId(407);
        int rows=majorDao.addMajor(major);
        if (rows>0)
            System.out.println("添加成功！");
        else
            System.out.println("添加失败！");
    }

    @Test
    public void findMajorByIdTest(){
        Major major=majorDao.findMajorById("414");
        System.out.println(major);
    }
    //2040706101 杨艾琳
    @Test
    public void updeteMajorTest(){
        Major major=majorDao.findMajorById("414");
        major.setMajorName("计算机");
        int rows=majorDao.updateMajor(major);
        if (rows>0)
            System.out.println("更新成功！");
        else
            System.out.println("更新失败！");
    }

    @Test
    public void deleteMajorTest(){
        int rows=majorDao.deleteMajorById("414");
        if (rows>0)
            System.out.println("删除成功！");
        else
            System.out.println("删除失败！");
    }
}
