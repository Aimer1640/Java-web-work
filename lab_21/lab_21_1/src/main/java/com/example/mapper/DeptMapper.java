package com.example.mapper;


import com.example.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface DeptMapper {
    //查询所有系别信息
    @Select(" select * from tb_dept where dept_id=#{deptId}")
    Dept findDeptById(Integer deptId);

    //查询所有系别信息
    @Select("select * from tb_dept")
    List<Dept> findAllDept();

    //按条件模糊查询系名
    @Select("select * from tb_dept  where dept_name like concat('%', #{deptname}")
    List<Dept> findByCondition(String deptname);

   //添加系名
    @Insert("insert into tb_dept(dept_id, dept_name) values(#{deptId}, #{deptname})")
    int insertDept(Dept d);

    //修改系的信息
    @Update("update tb_dept set dept_name = #{deptname} where dept_id = #{deptId")
    int  updateDept(Dept d);

    //删除系别
    /*@Delete("delete from tb_dept where dept_id=${deptId}")
    int  deleteDept(Integer deptId);*/
    //删除系别
    @Delete("delete from tb_dept where dept_id=${deptId}")
    int  deleteDept(Dept dept);

    //根据系编号查询所有专业信息
    @Select(value="select * from tb_dept where dept_id=#{deptId}")
    @Results({@Result(id=true,property="deptId",column="dept_id"),
            @Result(property="deptname",column="dept_name"),
            @Result(property="majorList",column="dept_id",
            many=@Many(select="cn.com.sise.mapper.MajorMapper.findMajorByDeptId",
                    fetchType= FetchType.LAZY))
    })
    Dept findMajorById(Integer dept_id);
}
