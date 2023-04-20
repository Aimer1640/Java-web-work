package com.example.service;

import com.example.pojo.Project;

import java.util.List;

public interface ProjectService {
    //发布作业
    public int distributeProject(Project project);

    //更新作业信息
    public int updateProject(Project project);

    //删除作业
    public int deleteProjectById(String projectId);

    //根据id查询作业
    public Project findProjectById(String projectId);

    //查询所有作业
    public List<Project> findAllProject();


}
