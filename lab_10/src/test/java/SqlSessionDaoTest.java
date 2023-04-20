import com.example.dao.MajorDao;
import com.example.pojo.Major;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SqlSessionDaoTest {
    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-bean1.xml");
    MajorDao majorDao=applicationContext.getBean("majorDao",MajorDao.class);

    @Test
    //添加专业
    public void addMajorTest(){
        Major major=new Major();
        major.setMajorId("31");
        major.setMajorName("计科");
        major.setTuition(260000);
        major.setDeptId(407);
        int rows=majorDao.addMajor(major);
        if (rows>0){
            System.out.println("添加成功");
        }
        else {
            System.out.println("添加失败");
        }
    }

    @Test
    //更新专业
    public void updateMajorTest(){
        Major major=new Major();
        major.setMajorId("31");
        major.setMajorName("计算机科学与技术");
        major.setTuition(26500);
        major.setDeptId(407);
        int rows=majorDao.updateMajor(major);
        if (rows>0){
            System.out.println("更新成功");
        }
        else {
            System.out.println("更新失败");
        }
    }

    @Test
    //删除专业
    public void deleteMajorByIdTest(){
        int rows=majorDao.deleteMajorById("31");
        if (rows>0){
            System.out.println("删除成功");
        }
        else {
            System.out.println("删除失败");
        }
    }

    @Test
    //根据id查询专业
    public void findMajorByIdTest(){
        Major major=majorDao.findMajorById("06");
        System.out.println(major);
    }

    @Test
    //查询所有专业
    public void findAllMajorTest(){
        List<Major> majorList=majorDao.findAllMajor();
        for(Major m:majorList){
            System.out.println(m);
        }
    }
}
