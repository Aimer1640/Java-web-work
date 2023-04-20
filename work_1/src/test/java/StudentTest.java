import com.example.mapper.StudentMapper;
import com.example.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class StudentTest {
    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-bean.xml");
    StudentMapper studentMapper=applicationContext.getBean(StudentMapper.class);

    @Test
    //添加学生
    public void registerStudentTest(){
        Student student=new Student();
        student.setStudnetId("6102");
        student.setStudentName("yal");
        student.setDeptId("407");
        student.setMajorId("06");
        student.setAbsence(0);
        int rows=studentMapper.registerStudent(student);
        if (rows>0){
            System.out.println("添加成功");
        }
        else {
            System.out.println("添加失败");
        }
    }

    @Test
    //更新学生
    public void updateStudentTest(){
        Student student=new Student();
        student.setStudnetId("6101");
        student.setStudentName("yal1");
        student.setMajorId("07");
        student.setDeptId("408");
        student.setAbsence(0);

        int rows=studentMapper.updateStudent(student);
        if (rows>0){
            System.out.println("更新成功");
        }
        else {
            System.out.println("更新失败");
        }
    }

    @Test
    //缺勤
    public void absenceStudent(){
        Student student=new Student();
        student.setStudnetId("6101");
        student.setAbsence(1);

        int rows=studentMapper.absenceStudent(student);
        if (rows>0){
            System.out.println("登记成功");
        }
        else {
            System.out.println("登记失败");
        }
    }
    @Test
    //删除学生
    public void deleteStudentByIdTest(){
        int rows=studentMapper.deleteStudentById("6102");
        if (rows>0){
            System.out.println("删除成功");
        }
        else {
            System.out.println("删除失败");
        }
    }

    @Test
    //根据id查询学生
    public void findStudentByIdTest(){
        Student student=studentMapper.findStudentById("6101");
        System.out.println(student);
    }

    @Test
    //查询所有学生
    public void findAllStudentTest(){
        List<Student> studentList=studentMapper.findAllStudent();
        for(Student s:studentList){
            System.out.println(s);
        }
    }
}
