package com.example.mapper;

import com.example.pojo.Coursework;
import com.example.pojo.Student;

import java.util.List;

public interface CourseWorkMapper {
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
