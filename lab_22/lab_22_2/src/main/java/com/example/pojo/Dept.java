package com.example.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "tb_dept")
public class Dept implements Serializable {

    @Id
    private Integer deptId;
    //2040706101 杨艾琳
    private String deptName;


    @OneToMany(
            mappedBy = "dept",
            cascade=CascadeType.ALL,
            targetEntity = Major.class,
            fetch= FetchType.LAZY
    )

    private List<Major> majorList;

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
