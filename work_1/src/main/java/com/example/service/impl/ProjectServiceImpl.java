package com.example.service.impl;

import com.example.mapper.ProjectMapper;
import com.example.pojo.Project;
import com.example.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    //发布作业
    @Override
    public int distributeProject(Project project) {
        int n=this.projectMapper.distributeProject(project);
        return n;
    }

    @Override
    public int updateProject(Project project) {
        int n=this.projectMapper.updateProject(project);
        return n;
    }

    @Override
    public int deleteProjectById(String projectId) {
        int n=this.projectMapper.deleteProjectById(projectId);
        return n;
    }

    @Override
    public Project findProjectById(String projectId) {
        Project project=this.projectMapper.findProjectById(projectId);
        return project;
    }

    @Override
    public List<Project> findAllProject() {
        List<Project> projects=this.projectMapper.findAllProject();
        return projects;
    }
}
