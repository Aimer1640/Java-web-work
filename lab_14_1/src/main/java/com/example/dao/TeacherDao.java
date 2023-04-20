package com.example.dao;

import com.example.pojo.Teacher;

import java.util.List;

public interface TeacherDao {

    //添加教师
    int addTeacher(Teacher teacher);

    //更新教师信息
    int updateTeacher(Teacher teacher);

    //删除教师
    int deleteTeacherById(Integer job_id);

    //根据角色查询所有教师信息
    List<Teacher> findTeacherByRole(Integer role);

    //查询指定工号的教师信息
    Teacher findTeacherById(Integer job_id);

    //根据系别查询所有教师信息
    List<Teacher> findTeacherByDept(Integer deptId);


}
