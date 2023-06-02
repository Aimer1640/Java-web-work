package com.example.mapper;

import com.example.pojo.Major;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import java.util.List;

public interface MajorMapper {
    //添加专业
    int addMajor(Major major);

    //更新专业
    int updateMajor(Major major);

    //删除专业
    int deleteMajorById(String majorId);

    //根据id查询专业
    Major findMajorById(String majorId);
    
    //查询所有专业
    List<Major> findAllMajors();

    //批量删除
    public void bathDeleteMajor(String []majorIds);

    //根据专业名称模糊查找专业信息
    @Select("select * from tb_major where major_name like concat('%',#{majorName},'%')")
    @Results({
            @Result(id=true,column="major_id",property="majorId"),
            @Result(column="major_name",property="majorName"),
            @Result(property="tuition",column="tuition"),
            //方式一：嵌套查询
            //一对一：@One注解-使用select属性引入另外一条SQL语句
            @Result(property="dept",column="dept_id",
                    one=@One(select="cn.com.sise.mapper.DeptMapper.findDeptById",
                            fetchType= FetchType.LAZY))
    })
    public List<Major> findByMajorName(String majorName);

    @Select("select * from tb_major where dept_id=#{dept_id}")
    @Results({
            @Result(id = true, column = "major_id", property = "majorId"),
            @Result(column = "major_name", property = "majorName"),
            @Result(property = "tuition", column = "tuition")
    })
    List<Major> findMajorByDeptId(Integer dept_id);
}
