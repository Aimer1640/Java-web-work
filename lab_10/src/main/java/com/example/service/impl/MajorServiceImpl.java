package com.example.service.impl;

import com.example.dao.impl.MajorDaoImpl;
import com.example.mapper.MajorMapper;
import com.example.pojo.Major;
import com.example.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("majorService")
@Transactional
//2040706101 杨艾琳
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorMapper majorMapper;
    //添加客户
    @Override
    public int addMajor(Major major) {
        int n=this.majorMapper.addMajor(major);
//        System.out.println(1/0);
        return n;
    }

    @Override
    public int updateMajor(Major major) {
        int n=this.majorMapper.updateMajor(major);
        return n;
    }

    @Override
    public int deleteMajorById(String majorId) {
        int n=this.majorMapper.deleteMajorById(majorId);
//        System.out.println(1/0);
        return n;
    }

    @Override
    public Major findMajorById(String majorId) {
        Major m=this.majorMapper.findMajorById(majorId);
        return m;
    }

    @Override
    public List<Major> findAllMajor() {
        List<Major> m=this.majorMapper.findAllMajor();
        return m;
    }
}
