import com.example.mapper.ProjectMapper;
import com.example.mapper.StudentMapper;
import com.example.pojo.Project;
import com.example.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProjectTest {
    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-bean.xml");
    ProjectMapper projectMapper=applicationContext.getBean(ProjectMapper.class);

    @Test
    //发布作业
    public void distributeProject(){
        Project project=new Project();
        project.setProjectId("0413");
        project.setProjectName("4月10作业");
        project.setProjectDemand("作业一");
        project.setProjectTeacher("101");
        project.setProjectState(0);
        int rows=projectMapper.distributeProject(project);
        if (rows>0){
            System.out.println("发布成功");
        }
        else {
            System.out.println("发布失败");
        }
    }

    //更新作业信息
    @Test
    public void updateProjectTest(){
        Project project=new Project();
        project.setProjectId("0410");
        project.setProjectName("4月10作业22");
        project.setProjectDemand("作业二");
        project.setProjectTeacher("101");
        project.setProjectState(0);
        int rows=projectMapper.updateProject(project);
        if (rows>0){
            System.out.println("修改成功");
        }
        else {
            System.out.println("修改失败");
        }
    }

    //删除作业
    @Test
    public void deleteProjectByIdTest(){
        int rows=projectMapper.deleteProjectById("0413");
        if (rows>0){
            System.out.println("删除成功");
        }
        else {
            System.out.println("删除失败");
        }
    }

    //根据id查询作业
    @Test
    public void findProjectByIdTest(){
        Project project=projectMapper.findProjectById("0410");
        System.out.println(project);
    }

    //查询所有作业
    @Test
    public void findAllProjectTest(){
        List<Project> projectList=projectMapper.findAllProject();
        for (Project p:projectList){
            System.out.println(p);
        }
    }

}
