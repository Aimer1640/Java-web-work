import com.example.spring.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAOPTest {

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StudentService student = (StudentService)context.getBean("studentService");
		//以自己的学号和姓名为例，分别测试save、update和delete方法
		student.save("2040706101", "杨艾琳");
		student.update("2040706101","101");
		student.delete("2040706101");
	}

}
