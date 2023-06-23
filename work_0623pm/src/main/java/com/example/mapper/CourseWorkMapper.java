package com.example.mapper;

import com.example.pojo.Coursework;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CourseWorkMapper {
    //学生提交作业
    @Insert("insert into tb_coursework(upload_id,student_id,project_id,upload_file,state) values(#{uploadId},#{studentId},#{projectId},#{uploadFile},#{state})")
    public int uploadWork(Coursework coursework);

    //修改已提交作业信息
    @Update("update tb_coursework set upload_file=#{uploadFile},state=#{state} where upload_id=#{uploadId}")
    public int updateWork(Coursework coursework);

    //撤回已提交的作业
    @Delete("delete from tb_coursework where upload_id=#{uploadId}")
    public int retructWork(String uploadId);

    //根据作业提交id查询提交的作业
    @Select("select * from tb_coursework where upload_id=#{uploadId}")
    @Results({@Result(id=true,property="uploadId",column="upload_id"),
            @Result(property="projectId",column="project_id"),
            @Result(property="studentId",column="student_id"),
            @Result(property="state",column="state"),
            @Result(property="uploadFile",column="upload_file"),
    })
    public Coursework findWorkByUploadId(String uploadId);

    //根据学生id查询提交的作业
    @Select("select * from tb_coursework where student_id=#{studentId}")
    public List<Coursework> findWorkByStuId(String studentId);

    //根据作业id查询提交的作业
    @Select("select * from tb_coursework where project_id=#{projectId}")

    public List<Coursework> findWorkByProjectId(String projectId);


    //查询所有已提交作业
    @Select("select * from tb_coursework")
    @Results({@Result(id=true,property="uploadId",column="upload_id"),
            @Result(property="projectId",column="project_id"),
            @Result(property="studentId",column="student_id"),
            @Result(property="state",column="state"),
            @Result(property="uploadFile",column="upload_file"),
    })
    public List<Coursework> findAllWork();
}
