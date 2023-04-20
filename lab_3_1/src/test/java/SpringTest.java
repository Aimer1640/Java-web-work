import com.example.pojo.Dept;
import com.example.pojo.Major;
import com.example.pojo.Class;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    //2040706101 杨艾琳
    //加载配置文件，实例化Spring容器
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void deptTest(){
        //测试计算机系信息的注入情况
//        System.out.println(applicationContext.getBean("dept"));
        Dept dept=(Dept) applicationContext.getBean("dept");
        dept.sayMajors();
    }

    //测试专业信息的注入情况
    @Test
    public void majorTest(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        System.out.println(applicationContext.getBean("major1"));
        Major major= (Major) applicationContext.getBean("major1");
        major.sayClasss();
    }

     //测试班级信息的注入情况
    @Test
    public void classTest(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Class c= (Class) applicationContext.getBean("c1",Class.class);
        c.sayTeacherProp();
    }

    @Test
    public void testpdept(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean-ns.xml");
        Dept dept=applicationContext.getBean("dept",Dept.class);
        System.out.println(dept);
        dept.sayMajors();
    }
    //2040706101 杨艾琳
    @Test
    public void testpmajor(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean-ns.xml");
        Major major=applicationContext.getBean("major1",Major.class);
        System.out.println(major);
        major.sayClasss();
    }

    @Test
    public void testpclass(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean-ns.xml");
        Class classs=applicationContext.getBean("c1",Class.class);
//        System.out.println(classs);
        classs.sayTeacherProp();
    }
}
