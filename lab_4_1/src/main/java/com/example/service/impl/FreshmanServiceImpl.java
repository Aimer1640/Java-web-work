package com.example.service.impl;

import com.example.mapper.FreshmanMapper;
import com.example.pojo.Freshman;
import com.example.service.FreshmanService;
import com.example.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class FreshmanServiceImpl implements FreshmanService {
     //1.通过工具类生成SqlSession对象
    SqlSession sqlSession = MybatisUtils.getSession();

    //2.实例化Mapper接口对象
    FreshmanMapper freshmanMapper=sqlSession.getMapper(FreshmanMapper.class);


    @Override
    public Freshman getFreshmanLogin(String ticketnumber, String id_card) {
        return freshmanMapper.getFreshmanLogin(ticketnumber,id_card);
    }

    @Override
    public List<Freshman> selectFreshmanByMultiple(Map<String, Object> params) {
       /* //创建Freshman对象的Map集合，封装需要组合查询的条件
        HashMap<String, Object> params = new HashMap<String, Object>();
        //params.put("ticketNumber", "");
        params.put("idCard", "445122199610045953");
        params.put("stuNo", "2040706101");*/
        //执行SqlSession的查询方法，返回结果集
        List<Freshman> f = freshmanMapper.selectFreshmanByMultiple(params);
        //打印输出结果
        for(Freshman ff:f)
            //打印输出结果
            System.out.println(ff.toString());
        System.out.println("新生信息查询成功！");
        return f;



//        SqlSession sqlSession=MybatisUtils.getSession();
//        FreshmanMapper freshmanMapper=sqlSession.getMapper(FreshmanMapper.class);
//        //sqlSession.commit(false);
//        freshmanMapper.selectFreshmanByMultiple(params);
//        sqlSession.commit();
//        //关闭SqlSession
//        sqlSession.close();
//        System.out.println("新生信息查询成功！");
//        return null;
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