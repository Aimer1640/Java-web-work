package com.example.pojo;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 专业类
 */
@Component
public class Major{
    private String majorId;//专业ID
    private String majorName;//专业
    private Integer tuition;//学费
    private Integer deptId;//系别ID
    private List<java.lang.Class> classs;//班级集合属性
    public Major(){}
    public Major(String majorId) {
        this.majorId = majorId;
    }
    //添加有参构造函数
    public Major(String majorId,String majorName,Integer tuition,List<java.lang.Class> classs) {
        this.majorId = majorId;
        this.majorName = majorName;
        this.tuition=tuition;
        this.classs=classs;
    }
    //为属性提供setter和getter方法
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

    public List<java.lang.Class> getClasss() {
        return classs;
    }

    public void setClasss(List<java.lang.Class> classs) {
        this.classs = classs;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorId='" + majorId + '\'' +
                ", majorName='" + majorName + '\'' +
                ", tuition=" + tuition +
                ", deptId=" + deptId +
                '}';
    }


    /**
     * 打印Map集合
     */
    public void sayClasss() {
        if (null != classs && classs.size() > 0) {
            System.out.println("注入Map集合-->");
            //遍历map的集合
            for (java.lang.Class c: classs) {
                System.out.println(c.toString());
            }
        }
    }

}