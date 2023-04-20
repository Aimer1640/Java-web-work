import com.example.mapper.CourseWorkMapper;
import com.example.pojo.Coursework;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseWorkTest {
    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-bean.xml");
    CourseWorkMapper courseWorkMapper=applicationContext.getBean(CourseWorkMapper.class);

    @Test
    void uploadWork() {
        Coursework coursework=new Coursework();
        coursework.setUploadId("5");
        coursework.setProjectId("0410");
        coursework.setStudentId("2040706105");
        coursework.setUploadFile("lab_1.word");
        coursework.setState("1");
        int rows=courseWorkMapper.uploadWork(coursework);
        if (rows>0){
            System.out.println("提交成功");
        }
        else {
            System.out.println("提交失败");
        }
    }

    @Test
    void updateWork() {
        Coursework coursework=new Coursework();
        coursework.setUploadId("5");
        coursework.setProjectId("0410");
        coursework.setStudentId("2040706105");
        coursework.setUploadFile("lab_1_1.word");
        coursework.setState("1");
        int rows=courseWorkMapper.updateWork(coursework);
        if (rows>0){
            System.out.println("修改成功");
        }
        else {
            System.out.println("修改失败");
        }

    }

    @Test
    void retructWork() {
        int rows=courseWorkMapper.retructWork("5");
        if (rows>0){
            System.out.println("删除成功");
        }
        else {
            System.out.println("删除失败");
        }
    }

    @Test
    void findWorkByStuId() {
        List<Coursework> courseworkList= (List<Coursework>) courseWorkMapper.findWorkByStuId("2040706101");
        for (Coursework c:courseworkList){
            System.out.println(c);
        }
    }

    @Test
    void findWorkByProjectId() {
        List<Coursework> courseworkList= (List<Coursework>) courseWorkMapper.findWorkByProjectId("0410");
        for (Coursework c:courseworkList){
            System.out.println(c);
        }
    }

    @Test
    void findAllWork() {
        List<Coursework> courseworkList=courseWorkMapper.findAllWork();
        for (Coursework c:courseworkList){
            System.out.println(c);
        }
    }
}