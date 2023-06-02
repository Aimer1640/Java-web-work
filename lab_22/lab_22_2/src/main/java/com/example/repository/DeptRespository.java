package com.example.repository;

import com.example.pojo.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeptRespository extends JpaRepository<Dept,Integer> {
    public List<Dept> findDeptByDeptNameContains(String deptName);
    //2040706101 杨艾琳

    @Query("delete from tb_dept where deptId=?1")
    @Transactional
    @Modifying
    public int deleteDept(Integer id);
}
