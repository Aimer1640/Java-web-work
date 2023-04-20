package com.example.pojo;

/**
 * 班级类
 */
//添加注解

public class Class{
    private Integer class_id;//班级ID
    private String class_name;//班名
    private Integer class_size;//班级人数
    private Integer class_surplus;//班级剩余人数
    private Integer dept_Id;//系别ID
    private String major_id;//专业ID
    private String tutor_id;//学习导师ID
    private String instructor_id;//辅导员ID
    private String bz;//备注
    private Major major;//关联属性，每个班级属于一个专业
    private Dept dept;//关联属性，每个班级属于一个系
    private Teacher tutor;//关联属性，每个班级有一个学习导师，其工号对应于tutorId
    private Teacher instructor;//关联属性，每个班级有一个辅导员，其工号对应于instructorId

    //添加无参构造函数
    public Class(){}

    //添加有参构造函数，设置班级所在专业、所在系，班级的指导老师和辅导员信息
   public Class(Major major,Dept dept,Teacher tutor,Teacher instructor){
       this.major_id=major.getMajorId();
       this.dept_Id=dept.getDeptId();
       this.tutor_id=tutor.getJobId();
       this.instructor_id=instructor.getJobId();
   }

    //为属性提供setter方法和getter方法

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Integer getClass_size() {
        return class_size;
    }

    public void setClass_size(Integer class_size) {
        this.class_size = class_size;
    }

    public Integer getClass_surplus() {
        return class_surplus;
    }

    public void setClass_surplus(Integer class_surplus) {
        this.class_surplus = class_surplus;
    }

    public Integer getDept_Id() {
        return dept_Id;
    }

    public void setDept_Id(Integer dept_Id) {
        this.dept_Id = dept_Id;
    }

    public String getMajor_id() {
        return major_id;
    }

    public void setMajor_id(String major_id) {
        this.major_id = major_id;
    }

    public String getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(String tutor_id) {
        this.tutor_id = tutor_id;
    }

    public String getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(String instructor_id) {
        this.instructor_id = instructor_id;
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

    @Override
    public String toString() {
        return "Class{" +
                "class_id=" + class_id +
                ", class_name='" + class_name + '\'' +
                ", class_size=" + class_size +
                ", class_surplus=" + class_surplus +
                ", dept_Id=" + dept_Id +
                ", major_id='" + major_id + '\'' +
                ", tutor_id='" + tutor_id + '\'' +
                ", instructor_id='" + instructor_id + '\'' +
                ", bz='" + bz + '\'' +
                ", major=" + major +
                ", dept=" + dept +
                ", tutor=" + tutor +
                ", instructor=" + instructor +
                '}';
    }
}