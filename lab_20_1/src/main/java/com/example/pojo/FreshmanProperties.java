package com.example.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration //等同@Component
@PropertySource("classpath:freshman.properties")
@ConfigurationProperties(prefix = "yal")
public class FreshmanProperties {
    private Integer politic;//政治面貌,0：群众，1：共青团员，2：党员
    private Integer deptId;//系别
    private String majorId;//专业
    private Integer classId;//班级ID
    private Integer dormId;//宿舍ID
    private Integer userId;//用户ID
    private String stuNo;//学号
    private Integer roleId;//角色

    @Override
    public String toString() {
        return "FreshmanProperties{" +
                "politic=" + politic +
                ", deptId=" + deptId +
                ", majorId='" + majorId + '\'' +
                ", classId=" + classId +
                ", dormId=" + dormId +
                ", userId=" + userId +
                ", stuNo='" + stuNo + '\'' +
                ", roleId=" + roleId +
                ", status=" + status +
                ", registerTime='" + registerTime + '\'' +
                '}';
    }

    public Integer getPolitic() {
        return politic;
    }

    public void setPolitic(Integer politic) {
        this.politic = politic;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getDormId() {
        return dormId;
    }

    public void setDormId(Integer dormId) {
        this.dormId = dormId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    private Integer status;//缴费状态,0：未缴费，1：未分配学号，2：未分配宿舍，3：已分配宿舍
    private String registerTime;//注册时间
}
