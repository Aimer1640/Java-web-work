import com.example.dao.TeacherDao;
import com.example.pojo.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyFactoryBeanTest {
    //    2040706101 杨艾琳
    public static void main(String []args){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        TeacherDao teacherDao= (TeacherDao) applicationContext.getBean("teacherDaoProxy");
        Teacher teacher=new Teacher("2040706101","0","0");
        teacherDao.addTeacherInfo(teacher);
        teacherDao.updateTeacherInfo("2040706101");
        teacherDao.updateTeacherInfo("2040706101");
        teacherDao.queryTeacherInfoById("2040706101");
    }
}
