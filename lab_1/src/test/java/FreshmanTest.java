import com.example.pojo.Freshman;
import com.example.service.FreshmanService;
import com.example.service.impl.FreshmanServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreshmanTest {
    @Test
    //查询所有新生信息
    //2040706101 杨艾琳
    public void testFindAll(){
        //初始化容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取实例
        FreshmanService freshmanService= (FreshmanService) applicationContext.getBean("freshservice");
        //调用方法
        List<Freshman> freshmanList=freshmanService.findAll();
        //显示所有新生信息
        for (Freshman f:freshmanList){
            System.out.println(f);
        }
    }
    @Test
    //2040706101 杨艾琳
    public void testAddFreshmamn(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        FreshmanService freshmanService=(FreshmanService) applicationContext.getBean("freshservice");

        Freshman freshman=new Freshman();
        freshman.setTicketNumber("2040706101");
        freshman.setIdCard("6101");
        freshman.setStuNo("2040706101");
        freshman.setBirthday(new Date());
        freshman.setSex(0);
        freshman.setName("YAL");
        freshman.setAge(20);

        Integer rows=freshmanService.addFreshman(freshman);
        if (rows>0)
            System.out.println("添加成功！");
        else
            System.out.println("添加失败");
    }

    @Test
    //2040706101 杨艾琳
    public void testdeleteFreshman() throws Exception{
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        FreshmanService freshmanService=(FreshmanService) applicationContext.getBean("freshservice");

        Map<String,Object> ticketnumber=new HashMap<String,Object>();
        ticketnumber.put("ticketnumber","2040706101");
        ticketnumber.put("idCard","6101");
//        System.out.println(ticketnumber);
        Integer rows=freshmanService.deleteFreshman(ticketnumber);

        if (rows>0)
            System.out.println("删除成功！");
        else
            System.out.println("删除失败");
    }

    @Test
    //2040706101 杨艾琳
    public void testupdateFreshman(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        FreshmanService freshmanService=(FreshmanService) applicationContext.getBean("freshservice");

        Freshman freshman=new Freshman();
        freshman.setIdCard("6101");
//        freshman.setBirthday(new Date());
        freshman.setStuNo("2040706105");
        freshman.setSex(1);
        freshman.setName("YAL");
        freshman.setAge(18);

        Integer rows=freshmanService.updateFreshman(freshman);
        if (rows>0)
            System.out.println("更新成功！");
        else
            System.out.println("更新失败");
    }
}
