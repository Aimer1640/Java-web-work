package com.example.controller;

import com.example.mapper.TeacherMapper;
import com.example.pojo.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TeacherController {

    @Resource
    private TeacherMapper teacherMapper;

    /*@Resource(name = "majorDao")
    private MajorDao majorDao;
    @Resource(name = "deptDao")
    private DeptDao deptDao;*/

    @RequestMapping("/toTeacherAdd")
    public String teacherForm(HttpSession session) {
        System.out.println("teacherForm called");
        session.setAttribute("deptId", 407);
        session.setAttribute("deptName", "计算机系");
        return "teacherAdd";
    }

    @RequestMapping("/teacherDelete")
    public String teacherDelete(Integer jobId) {
        System.out.println("teacherDelete called");
        int rows = teacherMapper.deleteTeacherById(jobId);
        if (rows > 0) System.out.println(rows + "个教师删除成功！");
        else System.out.println("教师删除失败！");
        return "redirect:toTeacherAll";
    }

    @RequestMapping("/findTeacherByRole")
    @ResponseBody
    public Map<String,Object> findTeacherByRole(HttpSession session, Integer role) {
        System.out.println("findAllTeacherByRole called");
        List<Teacher> tutors = teacherMapper.findTeacherByRole(0);
        List<Teacher>  instructors= teacherMapper.findTeacherByRole(1);
        HashMap<String, Object> map =new HashMap<String,Object>();
        map.put("tutors",tutors);
        map.put("instructors",instructors);
        return map;
    }

    @RequestMapping("/findTeacherById")
    public ModelAndView findTeacherById(Integer jobId) {
        System.out.println("findTeacherById called");
        Teacher t = teacherMapper.findTeacherById(jobId);
        //创建准备返回的模型视图对象，该对象通常包括返回的视图名、模型的名称及视图对象
        ModelAndView mv = new ModelAndView();
        // 添加模型数据，可以是任意的pojo对象
        mv.addObject("teacher", t);
        mv.setViewName("teacherEdit");
        return mv;
    }

    @RequestMapping("/findTeacherByDept")
    public String findTeacherByDept(HttpServletRequest req, Integer deptId) {
        System.out.println("toTeacherAl called");
        List<Teacher> ts = teacherMapper.findTeacherByDept(407);
        req.setAttribute("ts", ts);
        return "teacherAll";
    }

    @RequestMapping("/teacherAdd")
    public String teacherAdd(Teacher t) {
        System.out.println("teacherAdd called");
        t.setDeptId(407);
        int rows = teacherMapper.addTeacher(t);
        if (rows > 0) System.out.println(rows + "个教师添加成功！");
        else System.out.println("教师添加失败！");
        return "redirect:toTeacherAll";
    }

    @RequestMapping("/teacherUpdate")
    public String teacherUpdate(Teacher c) {
        System.out.println("teacherUpdate called");
        int rows = teacherMapper.updateTeacher(c);
        if (rows > 0) System.out.println(rows + "个教师修改成功！");
        else System.out.println("教师修改失败！");
        return "redirect:toTeacherAll";
    }

    @RequestMapping("/teachersDelete")
    public String teachersDelete(Integer[] jobIds) {
        System.out.println("teachersDelete called" + jobIds.toString());
        if (jobIds != null) {
            for (Integer id : jobIds) {
                teacherMapper.deleteTeacherById(id);
                // 使用输出语句模拟已经删除了教师
                System.out.println("删除了TeacherId为" + id + "的教师！");
            }
        } else {
            System.out.println("jobIds=null,教师删除失败！");
        }
        return "redirect:toTeacherAll";
    }
}
