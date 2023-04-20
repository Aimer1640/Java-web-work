package com.example.pojo;

import java.util.List;

import org.springframework.util.CollectionUtils;
/**
 * 系别类
 */
public class Dept{
    private Integer deptId;//系别ID
    private String deptName;//系名

    //添加无参构造函数
    public Dept(){}

    //添加有参构造函数，构造系的编码和名称信息
    public Dept(Integer deptId) {
        this.deptId = deptId;
    }
    public Dept(Integer deptId,String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    //为属性提供setter和getter方法
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '}';
    }

}