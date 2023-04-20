import java.util.List;

import com.example.dao.TeacherDao;
import com.example.pojo.Teacher;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTest {
	        //定义配置文件路径（绝对路径）
	      // String xmlPath="D:\Java Web应用开发框架（CW3012）\课件\第7讲 Spring数据库开发（1）\实验7 Spring的数据库开发（1）\lab07_1\src\main\resources\JdbcTemplate.xml";
	        //定义配置文件路径（相对路径）
			//	2040706101 杨艾琳
			//	String xmlPath= "JdbcTemplate-Beans.xml";
//	       String xmlPath= "JdbcTemplate-Beans.xml";
	       String xmlPath= "JdbcTemplate-AnnotionsBeans.xml";
	        //加载配置文件
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
	        //获取jdbcTemplate实例
			JdbcTemplate jdTemplate =applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);                           ;
			TeacherDao teacherDao = (TeacherDao) applicationContext.getBean("teacherDao");
	/**
	 * 使用execute方法建表
	 */
	@Test
	public void createTableTest(){
		String sql="DROP TABLE IF EXISTS 'tb_teacher';CREATE TABLE 'tb_teacher'("
				+ "'job_id' varchar(20) NOT NULL,"
				+ "'teacher_name' varchar(50)  NOT NULL,"
				+ "'gender' int(0)  NOT NULL,"
				+ "'tel' varchar(11) NOT NULL,"
				+ "'role' int(0) NOT NULL,"
				+ "'dept_id' int(0) DEFAULT NULL,"
				+ "PRIMARY KEY ('job_id'),"
				+ "CONSTRAINT 'tb_teacher_ibfk_1' FOREIGN KEY ('dept_id')"
				+ "REFERENCES 'tb_dept' ('dept_id') ON DELETE RESTRICT ON UPDATE CASCADE"
				+") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
//		String sql="create table tb_teachers(" + "job_id int primary key auto_increment," + "teacher_name varchar(50),"
//				+ "gender int (0),"+"tel varchar(11),"+"role int(0),"+"dept_id int(0))";

//		String sql="create table tb_teachers(" + "job_id int primary key auto_increment," + "teacher_name varchar(50),"
//				+ "gender int (0),"+"tel varchar(11),"+"role int(0),"+"dept_id int(0),"+"constraint tb_teacher_ibfk_1 foreign key dept_id,"+"references tb_dept (dept_id) on delete restrict on update cascade"+")";
//		String sql="DROP TABLE IF EXISTS `tb_teacher`;CREATE TABLE `tb_teacher`("
//				+ "`job_id` varchar(20) NOT NULL,"
//				+ "`teacher_name` varchar(50)  NOT NULL,"
//				+ " `gender` int(0)  NOT NULL,"
//				+ " `tel` varchar(11) NOT NULL,"
//				+ " `role` int(0)  NOT NULL,"
//				+ " `dept_id` int(0) DEFAULT NULL,"
//				+ "  PRIMARY KEY (`job_id`),"
//				+ " CONSTRAINT `tb_teacher_ibfk_1` FOREIGN KEY (`dept_id`) "
//				+ "REFERENCES `tb_dept` (`dept_id`) ON DELETE RESTRICT ON UPDATE CASCADE"
//				+") ENGINE=InnoDB DEFAULT CHARSET=utf-8;";
//
		//使用execute方法执行SQL语句，创建数据表
		jdTemplate.execute(sql);
	}


	/**
	 * 添加教师
	 */
//	2040706101 杨艾琳
	@Test
	public void addTeacherTest(){
		Teacher t = new Teacher();
		//向t对象添加属性值：自己的工号、姓名和性别
		t.setJobId("2040706101");
		t.setTeacherName("YAL");
        t.setGender(1);
		t.setRole(1);
		t.setTel("15978634569");
		t.setDeptId(407);
		//调用addTeacher方法，获取返回结果
		int flag = teacherDao.addTeacher(t);
		if(flag == 1){			
			System.out.println("注册成功");
		}else{
			System.out.println("注册失败");
		}
	}
	/**
	 * 更新教师数据
	 */
//	2040706101 杨艾琳
	@Test
	public void updateTeacherTest(){
		Teacher t = teacherDao.findTeacherById("2040706101");
//		Teacher t = new Teacher();
		//向t对象修改属性值：修改密码为自己的工号
//		t.setJobId("2040706101");
        t.setTeacherName("杨艾琳");
        t.setGender(0);
		//调用TeacherDao中的updateTeacher()方法执行更新
		int flag = teacherDao.updateTeacher(t);
		if(flag == 1){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
	}
	/**
	 * 删除教师数据
	 */
	//	2040706101 杨艾琳
	@Test
	public void deleteTeacherByJobId(){
		//调用deleteTeacherByJobId()方法，获取返回结果
		int flag =teacherDao.deleteTeacherById("2023");
		if(flag == 1){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
	}

//	@Test
//	public void findAllTeachersTest(){
//		List <Teacher> teachers=teacherDao.findAllTeachers();
//		for (Teacher t:teachers){
//			System.out.println(t);
//		}
//	}

	/**
	 * 根据工号JobId查找教师
	 */
	//	2040706101 杨艾琳
	@Test
	public void findTeacherByJobIdTest(){
		//获取teacherDao实例
		//TeacherDao teacherDao = (TeacherDao) applicationContext.getBean("TeacherDao");
		//调用findTeacherById方法，获取Teacher对象
		Teacher t =teacherDao.findTeacherById("2040706101");
        //输出查询结果
        System.out.println(t);
	}
	/**
	 * 查找所有学习导师
	 */
	@Test
	public void findTeacherByRoleTest(){
		//获取teacherDao实例
		//TeacherDao teacherDao = (TeacherDao) applicationContext.getBean("TeacherDao");
		//调用findAllTeacher方法，获取Teacher对象集合
        List<Teacher> ts =  teacherDao.findTeacherByRole(0);
        //循环输出集合中对象
      for(Teacher t:ts){
    	  System.out.println(t);
      }
	}

	/**
	 * 查找指定系所有教师
	 */
	//	2040706101 杨艾琳
	@Test
	public void findAllTeacherTest(){
		//获取teacherDao实例
		//TeacherDao teacherDao = (TeacherDao) applicationContext.getBean("TeacherDao");
		//调用findAllTeacher方法，获取Teacher对象集合
		List<Teacher> ts =  teacherDao.findTeacherByDept(407);
		//循环输出集合中对象
		for(Teacher t:ts){
			System.out.println(t);
		}
	}

}
