package com.example.pojo;

/**
 * 系别类
 */
public class Dept{
    private Integer deptId;//系别ID

    private Classes classes;
    private Major major;
    private Teacher teacher;
    // 2040706101 杨艾琳
    public Dept(Classes classes,Major major,Teacher teacher) {
        this.classes=classes;
        this.major=major;
        this.teacher=teacher;
    }
    //为属性提供setter和getter方法
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    private String deptname;//系名

    




    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptname='" + deptname + '}';
    }
}