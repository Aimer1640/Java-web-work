package com.example.mapper;
import com.example.pojo.Student;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
    //注册学生账号
    @Insert("insert into tb_student(student_id,student_name,major_id,dept_id,absence) values(#{studentId},#{studentName},#{majorId},#{deptId},#{absence})")
    public int registerStudent(Student student);

    //更新学生信息
    @Update("update tb_student set student_name=#{studentName},major_id=#{majorId},dept_id=#{deptId},absence=#{absence} where student_id=#{studentId}")
    public int updateStudent(Student student);

    //删除学生
    @Delete("delete from tb_student where student_id=#{studentId}")
    public int deleteStudentById(String studentId);

    //根据id查询学生
    @Select("select * from tb_student where student_id=#{studentId}")
    @Results({@Result(id=true,property="studentId",column="student_id"),
            @Result(property="studentName",column="student_name"),
            @Result(property="majorId",column="major_id"),
            @Result(property="deptId",column="dept_id"),
            @Result(property="absence",column="absence"),
    })
    public Student findStudentById(String studentId);

    //查询所有学生
    @Select("select * from tb_student")
    @Results({@Result(id=true,property="studentId",column="student_id"),
            @Result(property="studentName",column="student_name"),
            @Result(property="majorId",column="major_id"),
            @Result(property="deptId",column="dept_id"),
            @Result(property="absence",column="absence"),
    })
    public List<Student> findAllStudent();

    //缺勤
    @Update("update tb_student set absence=#{absence} where student_id=#{studentId}")
    public int absenceStudent(Student student);

}
