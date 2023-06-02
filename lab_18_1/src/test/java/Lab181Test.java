import com.example.Lab181Application;
import com.example.controller.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Lab181Application.class)
public class Lab181Test {
    @Autowired
    MyController myController;
    //2040706101 杨艾琳
    @Test
    public void sayHelloTest(){
        System.out.println(myController.sayHello());
    }
}
