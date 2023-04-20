package com.example.pojo;

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

    //为属性提供setter方法和getter方法
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

    public Teacher getTutor() {
        return tutor;
    }

    public void setTutor(Teacher tutor) {
        this.tutor = tutor;
    }

    public Teacher getInstructor() {
        return instructor;
    }

    public void setInstructor(Teacher instructor) {
        this.instructor = instructor;
    }

    private String tutorId;//学习导师ID
    private String instructorId;//辅导员ID
    private String bz;//备注
    private Major major;//关联属性，每个班级属于一个专业
    private Dept dept;//关联属性，每个班级属于一个系
    private Teacher tutor;//关联属性，每个班级有一个学习导师，其工号对应于tutorId
    private Teacher instructor;//关联属性，每个班级有一个辅导员，其工号对应于instructorId


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
                ", major=" + major +
                ", dept=" + dept +
                ", tutor=" + tutor +
                ", instructor=" + instructor +
                '}';
    }
}