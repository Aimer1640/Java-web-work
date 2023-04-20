package com.example.service.impl;

import com.example.mapper.FreshmanMapper;
import com.example.pojo.Freshman;
import com.example.service.FreshmanService;
import com.example.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class FreshmanServiceImpl2 implements FreshmanService {
    //2040706101 杨艾琳
     //1.通过工具类生成SqlSession对象
    SqlSession sqlSession = MybatisUtils.getSession();
    //2.实例化Mapper接口对象
    FreshmanMapper freshmanMapper=sqlSession.getMapper(FreshmanMapper.class);

    @Override
    public Freshman getFreshmanLogin(String ticketnumber, String id_card) {
        return freshmanMapper.getFreshmanLogin(ticketnumber,id_card);
    }
    //2040706101 杨艾琳
    @Override
    public List<Freshman> selectFreshmanByMultiple(Map<String, Object> params) {
        //执行SqlSession的查询方法，返回结果集
        List<Freshman> f = freshmanMapper.selectFreshmanByMultiple(params);
        //打印输出结果
        for(Freshman ff:f)
            //打印输出结果
            System.out.println(ff.toString());
        System.out.println("新生信息查询成功！");
        return f;
    }

    @Override
    public void addFreshman(Freshman f) {
        SqlSession sqlSession=MybatisUtils.getSession();
        FreshmanMapper freshmanMapper=sqlSession.getMapper(FreshmanMapper.class);
        //sqlSession.commit(false);
        freshmanMapper.addFreshman(f);
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
        System.out.println("新生信息添加成功！");
    }
    //2040706101 杨艾琳
    @Override
    public void updateFreshman(Freshman f) {
        SqlSession sqlSession=MybatisUtils.getSession();
        FreshmanMapper freshmanMapper=sqlSession.getMapper(FreshmanMapper.class);
        freshmanMapper.updateFreshman(f);
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
        //return rows;
        System.out.println("新生信息更新除成功！");
    }

    @Override
    public void deleteFreshman(Map<String, Object> param) {
        SqlSession sqlSession=MybatisUtils.getSession();
        FreshmanMapper freshmanMapper=sqlSession.getMapper(FreshmanMapper.class);
        freshmanMapper.deleteFreshman(param);
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
        System.out.println("新生信息删除成功！");
    }
    //2040706101 杨艾琳
    @Override
    public List<Freshman> findFreshmanByDeptIdsAsArray(Integer[] ids) {
        List<Freshman>  freshmans =freshmanMapper.findFreshmanByDeptIdsAsArray(ids);
        //输出查询结果信息
        for(Freshman f : freshmans) {
            //打印输出结果
            System.out.println(f.toString());
        }
        System.out.println("新生信息查询成功！");
        return freshmanMapper.findFreshmanByDeptIdsAsArray(ids);
    }
    //2040706101 杨艾琳
    @Override
    public List<Freshman> findFreshmanByDeptIdsAsList(List<Integer> ids) {
        List<Freshman>  freshmans = freshmanMapper.findFreshmanByDeptIdsAsList(ids);
        //输出查询结果信息
        for (Freshman f : freshmans) {
            // 打印输出结果
            System.out.println(f.toString());
        }
        System.out.println("新生信息查询成功！");
        return freshmanMapper.findFreshmanByDeptIdsAsList(ids);
    }
}