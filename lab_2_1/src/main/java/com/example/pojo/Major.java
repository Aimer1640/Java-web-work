package com.example.pojo;

/**
 * 专业类
 */
public class Major {

    private String majorId;//专业ID
    private String majorName;//专业
    // 2040706101 杨艾琳
    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Integer getTuition() {
        return tuition;
    }

    public void setTuition(Integer tuition) {
        this.tuition = tuition;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    private Integer tuition;//学费
    private Integer deptId;//系别ID  

    //为属性提供setter和getter方法
    

    @Override
    public String toString() {
        return "Major{" +
                "majorId='" + majorId + '\'' +
                ", majorName='" + majorName + '\'' +
                ", tuition=" + tuition +
                ", deptId=" + deptId +
                '}';
    }
}