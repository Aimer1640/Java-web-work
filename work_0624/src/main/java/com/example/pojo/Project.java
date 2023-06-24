package com.example.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="tb_project")
public class Project {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String projectId;
    private String projectName;
    private String projectTeacher;
    private String projectDemand;

    public Integer getProjectState() {
        return projectState;
    }

    public void setProjectState(Integer projectState) {
        this.projectState = projectState;
    }

    private Integer projectState;
    private String projectFile;
    public String getProjectDemand() {
        return projectDemand;
    }

    public void setProjectDemand(String projectDemand) {
        this.projectDemand = projectDemand;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectTeacher() {
        return projectTeacher;
    }

    public void setProjectTeacher(String projectTeacher) {
        this.projectTeacher = projectTeacher;
    }


    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectTeacher='" + projectTeacher + '\'' +
                ", projectDemand='" + projectDemand + '\'' +
                ", projectState=" + projectState +
                ", projectFile='" + projectFile + '\'' +
                '}';
    }

    public String getProjectFile() {
        return projectFile;
    }

    public void setProjectFile(String projectFile) {
        this.projectFile = projectFile;
    }

}
