package com.example.pojo;

/**
 * 老师类
 */
public class Teacher{
    // 2040706101 杨艾琳
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    private String jobId;//工号
    private String teacherName;
    private String gender;//性别
    private String tel;
    private String role;//角色   0：学习导师，1：辅导员
    private Integer deptId;

    //为属性提供setter和getter方法
    


    @Override
    public String toString() {
        return "Teacher{" +
                "jobId='" + jobId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", gender='" + gender + '\'' +
                ", tel='" + tel + '\'' +
                ", role='" + role + '\'' +
                ", deptId=" + deptId +
                '}';
    }
}