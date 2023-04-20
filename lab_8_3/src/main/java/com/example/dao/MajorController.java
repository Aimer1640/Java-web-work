package com.example.dao;

import com.example.dao.impl.MajorDaoImpl;
import com.example.pojo.Major;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;
//2040706101 杨艾琳

@Controller("majorController")
public class MajorController {
    @Resource(name = "majorDao")
    private MajorDaoImpl majorDao;
    public List<Major> findAllMajor(){
        List<Major> majors=majorDao.findAllMajor();
        for (Major m: majors){
            System.out.println(m.toString());
        }
        return majors;
    }

}
