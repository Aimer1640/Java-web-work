import com.example.pojo.Class;
import com.example.service.ClassService;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	// 获得spring容器，并操作
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans-xml.xml");
	ClassService classService=applicationContext.getBean("classService",ClassService.class);
	//测试查询
	@Test
	public void findClassByNameTest(){
		

	}

    //测试添加
	@Test
	public void addClassTest(){
		Class c=new Class();
		c.setClass_id(201);
		c.setClass_name("20web1");
		c.setDept_Id(407);
		int rows=classService.addClass(c);
		if (rows>0){
			System.out.println("添加成功");
		}
		else {
			System.out.println("添加失败");
		}

	}


}
