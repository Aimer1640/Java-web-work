package com.example.pojo;

import java.util.Date;

/**
 * 新生信息类cn
 */
public class Freshman {
    private static final long serialVersionUID = 1L;
    private String ticketNumber;//准考证号
    private String idCard;//身份证号
    private String name;//姓名
    private Integer sex;//性别,0：女，1：男
    private Integer age;//年龄
    private Date birthday;//生日
    private String nation;//民族
    private Integer politic;//政治面貌,0：群众，1：共青团员，2：党员
    private Integer deptId;//系别
    private String majorId;//专业
    private Integer classId;//班级ID
    private Integer dormId;//宿舍ID
    private Integer userId;//用户ID
    private String stuNo;//学号
    private Integer roleId;//角色
    private Integer status;//缴费状态,0：未缴费，1：未分配学号，2：未分配宿舍，3：已分配宿舍
    private String registerTime;//注册时间
    public Freshman() {
    }

    public Freshman(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Freshman(Integer dormId) {
        this.dormId = dormId;
    }

    public Freshman(Integer deptId, String majorId) {
        this.deptId = deptId;
        this.majorId = majorId;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getPolitic() {
        return politic;
    }

    public void setPolitic(Integer politic) {
        this.politic = politic;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptName(Integer deptId) {
        this.deptId = deptId;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public Integer getDormId() {
        return dormId;
    }

    public void setDormId(Integer dormId) {
        this.dormId = dormId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassName(Integer classId) {
        this.classId = classId;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "Freshman{" +
                "ticketNumber='" + ticketNumber + '\'' +
                ", idCard='" + idCard + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", nation='" + nation + '\'' +
                ", politic=" + politic +
                ", deptName='" + deptId + '\'' +
                ", majorName='" + majorId + '\'' +
                ", dormId=" + dormId +
                ", userId=" + userId +
                ", stuNo='" + stuNo + '\'' +
                ", roleId=" + roleId +
                ", status=" + status +
                ", className='" + classId + '\'' +
                ", registerTime='" + registerTime + '\'' +
                '}';
    }
}