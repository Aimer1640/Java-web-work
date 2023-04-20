package com.example.service;

import com.example.pojo.Coursework;

import java.util.List;

public interface CourseWorkService {
    //学生提交作业

    public int uploadWork(Coursework coursework);

    //修改已提交作业信息

    public int updateWork(Coursework coursework);

    //撤回已提交的作业

    public int retructWork(String uploadId);


    //根据学生id查询提交的作业

    public List<Coursework> findWorkByStuId(String studentId);

    //根据作业id查询提交的作业

    public List<Coursework> findWorkByProjectId(String projectId);


    //查询所有已提交作业

    public List<Coursework> findAllWork();
}
