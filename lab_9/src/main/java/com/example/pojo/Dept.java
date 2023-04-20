package com.example.pojo;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
/**
 * 系别类
 */
@Component
public class Dept{
    private Integer deptId;//系别ID
    private String deptname;//系名
    private List<Major> majors; //关联属性

    //添加无参构造函数
    public Dept(){}

    //添加有参构造函数，构造系的编码和名称信息
    public Dept(Integer deptId) {
        this.deptId = deptId;
    }
    public Dept(Integer deptId,String deptname,List<Major> majors) {
        this.deptId = deptId;
        this.deptname = deptname;
        this.majors=majors;
    }

    //为属性提供setter和getter方法
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

    public List<Major> getMajors() {
        return majors;
    }

    public void setMajors(List<Major> majors) {
        this.majors = majors;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptname='" + deptname + '}';
    }


    /**
     * 打印List集合
     */
    public void sayMajors() {
        if (!CollectionUtils.isEmpty(majors)) {
            System.out.println("注入List集合-->");
            for (Major major : majors) {
                System.out.println(major.toString());
            }
        }
    }

}