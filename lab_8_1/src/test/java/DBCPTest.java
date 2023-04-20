import com.example.dao.DeptDao;
import com.example.pojo.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DBCPTest {
    //2040706101 杨艾琳
    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("dbcp/dbcpBeans.xml");
    DeptDao deptdao=applicationContext.getBean("deptDao",DeptDao.class);
    @Test
    public void findAllDeptsTest(){
        List<Dept> depts=deptdao.findAllDepts();
        for (Dept d:depts){
            System.out.println(d);
        }
    }

    @Test
    public void addDeptTest(){
        Dept dept=new Dept();
        dept.setDeptId(414);
        dept.setDeptName("测试系2");
        int rows=deptdao.addDept(dept);
        if (rows>0)
            System.out.println("添加成功！");
        else
            System.out.println("添加失败！");
    }

    @Test
    public void findDeptByIdTest(){
        Dept dept=deptdao.findDeptById(414);
        System.out.println(dept);
    }
    //2040706101 杨艾琳
    @Test
    public void updeteDeptTest(){
        Dept dept=deptdao.findDeptById(414);
        dept.setDeptName("计算机系");
        int rows=deptdao.updateDept(dept);
        if (rows>0)
            System.out.println("更新成功！");
        else
            System.out.println("更新失败！");
    }

    @Test
    public void deleteDeptTest(){
        int rows=deptdao.deleteDeptById(414);
        if (rows>0)
            System.out.println("删除成功！");
        else
            System.out.println("删除失败！");
    }
}
