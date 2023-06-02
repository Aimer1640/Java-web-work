package com.example.mapper;


import com.example.pojo.Freshman;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface FreshmanMapper {
//    2040706101 杨艾琳
    List<Freshman> findFreshmanByConditions1(Freshman freshman);
    //添加新生信息
    int addFreshman(Freshman f);
    //修改新生信息
    int updateFreshman(Freshman f);
    //删除新生信息
    int deleteFreshman(Freshman f);


    //    @InsertProvider(type = FreshmanSqlProvider.class, method = "addFreshman")
    //    @SelectProvider(type = FreshmanSqlProvider.class, method = "updateFreshman")
    //    @SelectProvider(type = FreshmanSqlProvider.class, method = "deleteFreshman")

    //    @SelectProvider(type = FreshmanSqlProvider.class,method = "getFreshmanAll")
    List<Freshman> getAllFreshmans();
    //登录验证
//    @SelectProvider(type = FreshmanSqlProvider.class, method = "getFreshmanLogin")
    Freshman getFreshmanLogin(@Param("ticketNumber") String ticketnumber, @Param("idCard") String id_card);

    //多条件查询新生信息
//    @SelectProvider(type = FreshmanSqlProvider.class, method = "selectFreshmanByMultiple")
    List<Freshman> selectFreshmanByMultiple(Map<String, Object> params);



    //使用动态SQL中的<foreach>元素遍历指定系的新生信息--array
//    @Select("<script> " +
//            "select * from tb_freshman where dept_id in" +
//            "<foreach item='id' index='index' collection='array' open='(' separator=',' close=')'>" +
//            "#{id}" +
//            "</foreach>" +
//            "</script>")
    List<Freshman> findFreshmanByDeptIdsAsArray(Integer[] ids);

    //使用动态SQL中的<foreach>元素遍历指定系的新生信息--list
//    @Select("<script> " +
//            "select * from tb_freshman where dept_id in" +
//            "<foreach item='id' index='index' collection='list' open='(' separator=',' close=')'>" +
//            "#{id}" +
//            "</foreach>" +
//            "</script>")
    List<Freshman> findFreshmanByDeptIdsAsList(List<Integer> ids);
}
