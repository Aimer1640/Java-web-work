import com.example.controller.FreshmanController;
import com.example.controller.FreshmanController2;
import com.example.pojo.Freshman;
import com.example.service.impl.FreshmanServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TestAutoScan {
    //2040706101 杨艾琳
    //1.初始化spring容器，加载配置文件
    ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("bean-autoScan.xml");
    //2.通过容器获取FreshmanServiceImpl类的实例对象
    FreshmanController2 freshmanController= (FreshmanController2) applicationContext.getBean("freshmanController2");

    //日期格式化
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

    /**
     * (1)根据准考证号、身份证号和学号，查询新生信息
     */
    @Test
    public void selectFreshmanByMultipleTest() {
        //2040706101 杨艾琳
        //创建Freshman对象的Map集合，封装需要组合查询的条件
        HashMap<String, Object> params = new HashMap<String, Object>();
        //params.put("ticketNumber", "");
        params.put("idCard", "445122199610045953");
        params.put("stuNo", "2040706101");
        //执行SqlSession的查询方法，返回结果集
        List<Freshman> f = freshmanController.selectFreshmanByMultiple(params);
    }
    /**
     * (2)根据准考证号和身份证号进行登录验证
     */
    @Test
    public void getFreshmanLoginTest(){
        //2040706101 杨艾琳
        String ticketNumber="16445122105383";
        String idCard="445122199610045953";
        //执行SqlSession的查询方法，返回结果集
        String f = freshmanController.getFreshmanLogin(ticketNumber,idCard);
        //打印输出结果
        System.out.println(f.toString());
     }

   /**
     * (3)根据<foreach>元素，批量查询新生信息--List
     */
    @Test
    public void findFreshmanByDeptIdsAsListTest(){
        //2040706101 杨艾琳
        //创建List集合，封装查询的dept_id
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(401);
        ids.add(402);
        ids.add(403);
        ids.add(404);
        ids.add(405);
        ids.add(406);
        //执行SqlSession的查询方法，返回结果集
        List<Freshman>  freshmans = freshmanController.findFreshmanByDeptIdsAsList(ids);
    }
    /**
     * (4)根据<foreach>元素，批量查询新生信息--Array
     */
    @Test
    public void findFreshmanByDeptIdsAsArrayTest(){
        //2040706101 杨艾琳
        //创建Array集合，封装查询的dept_id
        Integer[] ids= {401,402,403,404,405};
        //执行SqlSession的查询方法，返回结果集
        List<Freshman>  freshmans =freshmanController.findFreshmanByDeptIdsAsArray(ids);
    }

    /**
     * (5)添加新生信息
     */
    @Test
    public void addFreshmanTest() {
        //2040706101 杨艾琳
        Freshman f=new Freshman();
        f.setIdCard("101");
        f.setTicketNumber("2040706101");
        f.setName("yal");
        f.setSex(0);
        f.setAge(21);
        f.setBirthday(new Date(1970-01-01));
        f.setNation("汉");
        f.setRegisterTime(formatter.format(new Date()));
        f.setStatus(0);
        freshmanController.addFreshman(f);
    }
    /**
     * (6)修改新生信息
     */
    @Test
    public void updateFreshmanTest() {
        //2040706101 杨艾琳
        Freshman f=new Freshman();
        f.setIdCard("101");
        f.setTicketNumber("2040706101");
        f.setName("yal");
        f.setSex(0);
        f.setAge(19);
        f.setNation("汉族");
        freshmanController.updateFreshman(f);
   }

    /**
     * (7)删除新生信息
     */
    @Test
    public void deleteFreshmanTest() {
        //2040706101 杨艾琳
        //创建Freshman对象的Map集合，封装需要组合查询的条件
        HashMap<String, Object> params = new HashMap<String, Object>();
        //params.put("ticketNumber", "");
        params.put("idCard", "101");
        params.put("ticketNumber", "2040706101");
        freshmanController.deleteFreshman(params);
    }

}