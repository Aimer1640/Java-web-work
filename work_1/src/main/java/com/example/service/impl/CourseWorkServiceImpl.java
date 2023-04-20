package com.example.service.impl;

import com.example.mapper.CourseWorkMapper;
import com.example.pojo.Coursework;
import com.example.service.CourseWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("courseWorkService")
public class CourseWorkServiceImpl implements CourseWorkService {
    @Autowired private CourseWorkMapper courseWorkMapper;

    @Override
    public int uploadWork(Coursework coursework) {
        int n=this.courseWorkMapper.uploadWork(coursework);
        return n;
    }

    @Override
    public int updateWork(Coursework coursework) {
        int n=this.courseWorkMapper.updateWork(coursework);
        return n;
    }

    @Override
    public int retructWork(String uploadId) {
        int n=this.courseWorkMapper.retructWork(uploadId);
        return n;
    }

    @Override
    public List<Coursework> findWorkByStuId(String studentId) {
        List<Coursework> coursework=this.courseWorkMapper.findWorkByStuId(studentId);
        return coursework;
    }

    @Override
    public List<Coursework> findWorkByProjectId(String projectId) {
        List<Coursework> coursework=this.courseWorkMapper.findWorkByProjectId(projectId);
        return coursework;
    }

    @Override
    public List<Coursework> findAllWork() {
        List<Coursework> courseworks=this.courseWorkMapper.findAllWork();
        return courseworks;
    }
}
