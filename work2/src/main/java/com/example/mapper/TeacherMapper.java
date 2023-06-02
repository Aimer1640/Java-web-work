package com.example.mapper;

import com.example.pojo.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TeacherMapper {
    //注册教师账号
    @Insert("insert into tb_teacher(teacher_id,teacher_name,major_id,dept_id,role) values(#{teacherId},#{teacherName},#{majorId},#{deptId},#{role})")
    public int registerTeacher(Teacher teacher);

    //更新教师信息
    @Update("update tb_teacher set teacher_name=#{teacherName},major_id=#{majorId},dept_id=#{deptId},role=#{role} where teacher_id=#{teacherId}")
    public int updateTeacher(Teacher teacher);

    //删除教师
    @Delete("delete from tb_teacher where teacher_id=#{teacherId}")
    public int deleteTeacherById(String teacherId);

    //根据id查询教师
    @Select("select * from tb_teacher where teacher_id=#{teacherId}")
    public Teacher findTeacherById(String teacherId);

    //查询所有教师
    @Select("select * from tb_teacher")
    public List<Teacher> findAllTeacher();
}
