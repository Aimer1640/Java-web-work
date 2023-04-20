import com.example.dao.ClassDao;
import com.example.pojo.Class;
import com.example.pojo.Teacher;
import com.example.service.ClassService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringTest {
	// 获得spring容器，并操作
//	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans-xml.xml");
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans-annotation.xml");
	ClassService classService=applicationContext.getBean("classService",ClassService.class);
	//测试查询
	@Test
	public void findClassByNameTest(){
		List<Class> cl=classService.findClassByName("20web应用软件开发1班");
		for(Class c:cl){
			System.out.println(c);
		}
	}
	//2040706101 杨艾琳
	@Test
	public void findAllClassByDeptTest(){
		List<Class> cl=classService.findAllClassByDept(407);
		for(Class c:cl){
			System.out.println(c);
		}
	}
	@Test
	public void findAllClassByMajorTest(){
		List<Class> cl=classService.findAllClassByMajor(06);
		for(Class c:cl){
			System.out.println(c);
		}
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
	//2040706101 杨艾琳
	@Test
	public void delClassTest(){
		int rows=classService.deleteClassById(202);
		if (rows>0)
			System.out.println("删除成功！");
		else
			System.out.println("删除失败！");
	}
	//2040706101 杨艾琳
	@Test
	public void updateClass(){
		Class c=new Class();
		c.setClass_id(201);
		c.setClass_name("111");
		int rows=classService.updateClass(c);
		if (rows>0){
			System.out.println("修改成功");
		}
		else {
			System.out.println("修改失败");
		}
	}


}
