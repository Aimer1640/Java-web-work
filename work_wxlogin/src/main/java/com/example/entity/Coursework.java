package com.example.entity;

public class Coursework {
    private String projectId;
    private String uploadId;
    private String studentId;
    private String state;
    private String uploadFile;
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Coursework{" +
                "projectId='" + projectId + '\'' +
                ", uploadId='" + uploadId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", state='" + state + '\'' +
                ", uploadFile='" + uploadFile + '\'' +
                '}';
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(String uploadFile) {
        this.uploadFile = uploadFile;
    }


}
