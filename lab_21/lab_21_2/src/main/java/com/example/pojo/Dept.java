package com.example.pojo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;

/**
 * 系别类
 */
public class Dept extends Wrapper<Dept> {
    private Integer deptId;//系别ID
    private String deptName;//系名
//    private List<Major> majorList;

    public Dept() {  }

    @Override
    public Dept getEntity() {
        return null;
    }

    @Override
    public MergeSegments getExpression() {
        return null;
    }

    @Override
    public void clear() {

    }

    public Dept(Integer deptId) {
        this.deptId = deptId;
    }
    public Dept(Integer deptId,String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

//    public List<Major> getMajorList() {
//        return majorList;
//    }
//
//    public void setMajorList(List<Major> majorList) {
//        this.majorList = majorList;
//    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }


    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    @Override
    public String getSqlSegment() {
        return null;
    }
}