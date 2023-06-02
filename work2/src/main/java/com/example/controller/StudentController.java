package com.example.controller;

import com.example.mapper.StudentMapper;
import com.example.pojo.User;
import org.apache.commons.io.FileUtils;
import com.example.pojo.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentMapper studentMapper;
    @RequestMapping("/findAllStudents")
    public String findAllStudents(Model model){
        List<Student> students=studentMapper.findAllStudent();
        model.addAttribute("studentList",students);
        return "showAllStudents";
    }

    @GetMapping(value = "/addStudent")
    public String toaddStudent(){
        return "administrator/addStudent";
    }

    @PostMapping(value = "/addStudent")
    public String addStudent(Student s){
//        c.setDeptId(407);
        int rows=studentMapper.registerStudent(s);
        return "redirect:/student/findAllStudents";
    }

    @RequestMapping("/deleteStudentById/{studentId}")
    public String deleteStudentById(@PathVariable String studentId, HttpServletRequest request){
        int rows=studentMapper.deleteStudentById(studentId);
        String contextPath=request.getContextPath();
        return "redirect:/student/findAllStudents";
    }

    @RequestMapping("/findStudentByStudentId/{studentId}")
    public String findStudentByStudentId(@PathVariable("studentId") String studentId,Model model){
        System.out.println(studentId);
        Student s=studentMapper.findStudentById(studentId);
        model.addAttribute("s",s);
        System.out.println(s);
        return "/updateStudent";
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(Student s){
        System.out.println(s);
        int rows=studentMapper.updateStudent(s);
        return "redirect:/student/findAllStudents";
    }

    @GetMapping("/toUpload")
    public String toUpload(){
        return "/upload";
    }
//2040706101 杨艾琳
    @PostMapping("/toUpload")
    public String uploadFile(@RequestParam("uploadFile")List<MultipartFile> uploadFile, HttpSession session, HttpServletRequest request){
        if (!uploadFile.isEmpty() && uploadFile.size() > 0) {
            for (MultipartFile file : uploadFile) {
                String originalFilename = file.getOriginalFilename();
                String dirPath=request.getRealPath("/upload");
                System.out.println(dirPath);
                File filePath = new File(dirPath);
                // 如果保存文件的地址不存在，就先创建目录
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                User user= (User) session.getAttribute("USER_SESSION");
                String newFilename = user.getAccount()+ "_"+ UUID.randomUUID() +
                        "_"+originalFilename;
                System.out.println(dirPath + File.separator +newFilename);
                try {
                    // 使用MultipartFile接口的方法完成文件上传到指定位置
                    file.transferTo(new File(dirPath +File.separator + newFilename));
                } catch (Exception e) {
                    e.printStackTrace();
                    return "/error";
                }
            }
            // 跳转到成功页面
            return "administrator/administrator";
        }else{
            return"error";
        }
    }

//    @RequestMapping("toDownloadReport")
//    public String toDownloadReport(){
//        return "freshman/downloadReport";
//    }
//    //2040706101 杨艾琳
//    @RequestMapping("/download")
//    public ResponseEntity<byte[]> download(String filename, HttpServletRequest request) throws IOException {
//        //指定下载目录
//        String dirPath=request.getRealPath("/upload");
//        //创建下载对象
//        File file=new File(dirPath + File.separator +filename);
//        //响应头
//        HttpHeaders headers = new HttpHeaders();
//        //对文件名进行编码
//        filename=this.getFilename(request,filename);
//        // 通知浏览器以下载的方式打开文件
//        headers.setContentDispositionFormData("attachment", filename);
//        // 定义以流的形式下载返回文件数据
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        // 使用Sring MVC框架的ResponseEntity对象封装返回下载数据
//        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
//    }
//
//    public String getFilename(HttpServletRequest request,String filename) throws UnsupportedEncodingException {
//        String[] IEKeyWords={"MISE","Trident","Edge"};
////2040706101 杨艾琳
//        String userAgent=request.getHeader("User-Agent");
//        for (String keyWord:IEKeyWords){
//            if (userAgent.contains(keyWord)){
//                return URLEncoder.encode(filename,"UTF-8");
//            }
//        }
//        //非ie浏览器
//        return new String(filename.getBytes("UTF-8"),"ISO-8859-1");
//    }
}
