package com.example.pojo;

import org.springframework.stereotype.Component;

/**
 * 老师类
 */
@Component
public class Teacher{
    private String jobId;//工号
    private String teacherName;
    private int gender;//性别  0:女  1：男
    private String tel;
    private int role;//角色   0：学习导师，1：辅导员
    private Integer deptId;

    //添加无参构造函数
  public Teacher(){}

    //添加有参构造函数，
  public Teacher(String jobId,int gender,int role){
      this.jobId=jobId;
      this.gender=gender;
      this.role=role;
  }

    //为属性提供setter和getter方法
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

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