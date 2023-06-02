package com.example.repository;

import com.example.pojo.Dept;
import com.example.pojo.Major;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MajorRepository extends JpaRepository<Major,String> {
    public List<Major> findMajorsByMajorNameContainsAndDeptId(String majorName);
}
