package com.example.pojo;

import java.util.Properties;

/**
 * 班级类
 */
public class Class{

    private Integer classId;//班级ID
    private String className;//班名
    private Integer classSize;//班级人数
    private Integer classSurplus;//班级剩余人数
    private String tutorId;//学习导师ID
    private String instructorId;//辅导员ID
    private String bz;//备注
    private Major major;//关联属性，每个班级属于一个专业
    private Dept dept;//关联属性，每个班级属于一个系
    //添加无参构造函数
    public Class(){}

    //添加有参构造函数，设置班级所在专业、所在系，班级的指导老师和辅导员信息
    public Class(Major major, Dept dept, Properties teacherProp) {
        this.major = major;
        this.dept = dept;
        this.tutorId= (String) teacherProp.get("tutorId");
        this.instructorId= (String) teacherProp.get("instructorId");
    }

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

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }


    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", classSize=" + classSize +
                ", classSurplus=" + classSurplus +
                ", tutorId='" + tutorId + '\'' +
                ", instructorId='" + instructorId + '\'' +
                ", bz='" + bz + '}'+
                "\nmajor=" + major +
                "\ndept=" + dept +
                '}';
    }
}