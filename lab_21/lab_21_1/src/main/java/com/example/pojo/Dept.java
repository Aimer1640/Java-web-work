package com.example.pojo;

/**
 * 系别类
 */
public class Dept {
    private Integer deptId;//系别ID
    private String deptname;//系名
//    private List<Major> majorList;

    public Dept() {  }

    public Dept(Integer deptId) {
        this.deptId = deptId;
    }
    public Dept(Integer deptId, String deptname) {
        this.deptId = deptId;
        this.deptname = deptname;
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

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptname='" + deptname + '\''+"}";
    }
}