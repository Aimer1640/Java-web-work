package com.example.mapper;

import com.example.pojo.Class;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface ClassMapper {
        //添加班级
    @Insert("insert into tb_class(class_id,class_name,class_size,class_surplus,dept_id," +
            "major_id,tutor_id,instructor_id,bz)values(#{classId},#{className},#{classSize},#{classSurplus},#{deptId},#{majorId},#{tutorId},#{instructorId},#{bz})")
    public int addClass(Class c);

    //更新班级
    @Update("update tb_class set class_name =#{className},class_size=#{classSize},class_surplus=#{classSurplus},tutor_id=#{tutorId}," +
            "instructor_id=#{instructorId},bz=#{bz} where class_id =#{classId}")
    public int updateClass(Class c);

    //删除某个班级
    @Delete("delete from tb_class where class_id =#{classId}")
    public int deleteClassById(Integer classId);

    //根据id查找某个班级
    @Select("select * from tb_class where class_id=#{classId}")
    @Results({@Result(id=true,property="classId",column="class_id"),
            @Result(property="className",column="class_name"),
            @Result(property="classSize",column="class_size"),
            @Result(property="classSurplus",column="class_surplus"),
            @Result(property="tutorId",column="tutor_id"),
            @Result(property="instructorId",column="instructor_id"),
            @Result(property="bz",column="bz"),
    })
    public Class findClassById(Integer classId);

    //根据班级名称查询班级
    public List<Class> findClassByName(String className);

    //查询某个系的所有班级
    @Select("select * from tb_class where dept_id=#{deptId}")
    @Results({@Result(id=true,property="classId",column="class_id"),
            @Result(property="className",column="class_name"),
            @Result(property="classSize",column="class_size"),
            @Result(property="classSurplus",column="class_surplus"),
            @Result(property="tutorId",column="tutor_id"),
            @Result(property="instructorId",column="instructor_id"),
            @Result(property="bz",column="bz"),
    })
    public List<Class> findAllClassByDept(Integer deptId);

    //查询某个专业的所有班级
    public List<Class> findAllClassByMajor(Integer majorId);

    //批量删除
    @Delete("delete * from tb_class where class_id in #{id}")
    public int deleteClassesByIds(String[] id);
}
