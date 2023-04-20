package com.example.pojo;

public class Student {
    private String studentId;//学生ID（学号）
    private String studentName;//姓名

    private String majorId;//专业ID
    private String majorName;//专业

    private Integer tuition;//学费

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    private String deptId;//系别ID
    private Integer absence;//缺勤

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getAbsence() {
        return absence;
    }

    public void setAbsence(Integer absence) {
        this.absence = absence;
    }



    public Student() {
    }

    public Student(String studentId){
        this.studentId=studentId;
    }

//    public Major(String majorId) {
//        this.majorId = majorId;
//    }
    //添加有参构造函数
    public Student(String studnetId, String studentName, String deptId) {
        this.majorId = majorId;
        this.majorName = majorName;
        this.deptId=deptId;
    }
    //为属性提供setter和getter方法
    public String getStudnetId() {
        return studentId;
    }

    public void setStudnetId(String studnetId) {
        this.studentId = studnetId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

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

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", majorId='" + majorId + '\'' +
                ", majorName='" + majorName + '\'' +
                ", tuition=" + tuition +
                ", deptId='" + deptId + '\'' +
                ", absence=" + absence +
                '}';
    }
}
