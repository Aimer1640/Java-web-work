package com.example.controller;

import com.example.entity.Project;
import com.example.mapper.ProjectMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Resource
    private ProjectMapper projectMapper;

    @RequestMapping("/findAllProjects")
    public List<Project> findAllProject(){
        // 从数据库中查询出信息
        List<Project> projects=projectMapper.findAllProject();
        return projects;
    }

    @RequestMapping("/deleteProject")
    public int delete(String projectId){
        System.out.println(projectId);
        return projectMapper.deleteProjectById(projectId);
    }
}
