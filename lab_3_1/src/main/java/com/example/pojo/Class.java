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
    private Integer deptId;//系别ID
    private String majorId;//专业ID
    private String tutorId;//学习导师ID
    private String instructorId;//辅导员ID
    private String bz;//备注
    private Major major;//关联属性，每个班级属于一个专业
    private Dept dept;//关联属性，每个班级属于一个系
    private Properties teacherProp;//学习导师和辅导员的集合
    //添加无参构造函数
    public Class(){}
    //2040706101 杨艾琳
    //添加有参构造函数，设置班级所在专业、所在系，班级的指导老师和辅导员信息
    public Class(Major major, Dept dept, Properties teacherProp) {
        this.major = major;
        this.dept = dept;
        this.tutorId= (String) teacherProp.get("tutorId");
        this.instructorId= (String) teacherProp.get("instructorId");
        this.deptId=dept.getDeptId();
        this.majorId=major.getMajorId();
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

    public Properties getTeacherProp() {
        return teacherProp;
    }

    public void setTeacherProp(Properties teacherProp) {
        this.teacherProp = teacherProp;
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
                ", bz='" + bz + '}'+
                "\nmajor=" + major +
                "\ndept=" + dept +
                '}';
    }

    /**
     * 打印Properties属性
     */
    public void sayTeacherProp() {
        if (null != teacherProp) {
            System.out.println("注入properties属性-->");
            System.out.println("学习导师："+teacherProp.get("tutorId")+" "+teacherProp.get("tutorName"));
            System.out.println("辅导员："+teacherProp.get("instructorId")+" "+teacherProp.get("instructorName"));
       }
    }

}