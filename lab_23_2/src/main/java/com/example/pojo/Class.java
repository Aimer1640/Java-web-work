package com.example.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.Properties;

/**
 * 班级类
 */
@RedisHash("classes")
public class Class{

    @Id
    private Integer classId;//班级ID
    @Indexed
    private String className;//班名

    private Integer classSize;//班级人数
    private Integer classSurplus;//班级剩余人数
    private Integer deptId;//系别ID
    private String majorId;//专业ID
    private String tutorId;//学习导师ID
    private String instructorId;//辅导员ID
    private String bz;//备注

    //为属性提供setter和getter方法
    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getClassSize() {
        return classSize;
    }

    public void setClassSize(Integer classSize) {
        this.classSize = classSize;
    }

    public Integer getClassSurplus() {
        return classSurplus;
    }

    public void setClassSurplus(Integer classSurplus) {
        this.classSurplus = classSurplus;
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

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", classSize=" + classSize +
                ", classSurplus=" + classSurplus +
                ", deptId=" + deptId +
                ", majorId='" + majorId + '\'' +
                ", tutorId='" + tutorId + '\'' +
                ", instructorId='" + instructorId + '\'' +
                ", bz='" + bz + '\'' +
                '}';
    }
}