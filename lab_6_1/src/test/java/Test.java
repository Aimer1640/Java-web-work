import com.example.action.PersonAction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args){
		//得到Spring容器
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		PersonAction userAction=(PersonAction) context.getBean("personAction");
		String result=userAction.execute();
	}

}
