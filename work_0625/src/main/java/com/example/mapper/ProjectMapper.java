package com.example.mapper;

import com.example.pojo.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProjectMapper {
    //发布作业
    @Insert("insert into tb_project(project_id,project_name,project_demand,project_teacher,project_state,project_file) values(#{projectId},#{projectName},#{projectDemand},#{projectTeacher},#{projectState},#{projectFile})")
    public int distributeProject(Project project);

    //更新作业信息
    @Update("update tb_project set project_name=#{projectName},project_demand=#{projectDemand},project_teacher=#{projectTeacher},project_state=#{projectState},project_file=#{projectFile} where project_id=#{projectId}")
    public int updateProject(Project project);

    //删除作业
    @Delete("delete from tb_project where project_id=#{projectId}")
    public int deleteProjectById(String projectId);

    //根据id查询作业
    @Select("select * from tb_project where project_id=#{projectId}")
    @Results({@Result(id=true,property="projectId",column="project_id"),
            @Result(property="projectName",column="project_name"),
            @Result(property="projectTeacher",column="project_teacher"),
            @Result(property="projectDemand",column="project_demand"),
            @Result(property="projectState",column="project_state"),
            @Result(property="projectFile",column="project_file"),
    })
    public Project findProjectById(String projectId);

    //查询所有作业
    @Select("select * from tb_project")
    @Results({@Result(id=true,property="projectId",column="project_id"),
            @Result(property="projectName",column="project_name"),
            @Result(property="projectTeacher",column="project_teacher"),
            @Result(property="projectDemand",column="project_demand"),
            @Result(property="projectState",column="project_state"),
            @Result(property="projectFile",column="project_file"),
    })
    public List<Project> findAllProject();
}
