import com.example.pojo.Classes;
import com.example.pojo.Dept;
import com.example.pojo.Major;
import com.example.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    // 2040706101 杨艾琳
    @Test
    public void testDept(){
        //加载配置文件，实例化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //测试计算机系信息的注入情况
        Dept dept=(Dept) context.getBean("dept");
        System.out.println("deptid:"+dept.getDeptId()+"\ndeptname:"+dept.getDeptname());
    }

    @Test
    public void testMajor(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //测试专业信息的注入情况
        Major major=(Major) context.getBean("major");
        System.out.println("majorid:"+major.getMajorId()+"\nmajorname:"+major.getMajorName()+"\ntuition:"+major.getTuition());
    }

    //测试学习导师信息的注入情况
    @Test
    public void testTeacher(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Teacher teacher=(Teacher) context.getBean("teacher");
        System.out.println("teacherrole:"+teacher.getRole());
    }
    // 2040706101 杨艾琳
    //测试辅导员信息的注入情况
    @Test
    public void testTeacher2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Teacher teacher=(Teacher) context.getBean("teacher2");
        System.out.println("teacherrole:"+teacher.getRole());
    }

    @Test
    //测试班级信息的注入情况
    public void testClass(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Classes classes=(Classes) context.getBean("classes");
        System.out.println("classesid:"+classes.getClassId()+"\nclassname:"+classes.getClassName());
    }


}
