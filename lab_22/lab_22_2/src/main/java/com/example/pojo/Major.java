
package com.example.pojo;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "tb_major")

public class Major implements Serializable {
    @Id
    private String majorId;

    private String majorName;
    private Integer tuition;

    @OneToOne(
            fetch = FetchType.EAGER,
            targetEntity = Dept.class
    )
    @JoinColumn(
            name = "deptId",
            referencedColumnName = "deptId"
    )
    private Dept dept;


    @Override
    public String toString() {
        return "Major{" +
                "majorId='" + majorId + '\'' +
                ", majorName='" + majorName + '\'' +
                ", tuition=" + tuition +
                ", dept=" + dept +
                '}';
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

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
