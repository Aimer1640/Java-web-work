package com.example.controller;

import com.example.mapper.CourseWorkMapper;
import com.example.pojo.Coursework;
import com.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/coursework")
public class CourseWorkController {
    @Resource
    private CourseWorkMapper courseWorkMapper;
    @RequestMapping("/findAllCourseWork")
    public String findAllCourseWork(Model model){
        List<Coursework> courseworks=courseWorkMapper.findAllWork();
        model.addAttribute("courseworkList",courseworks);
        return "showAllCourseWork";
    }

    @GetMapping(value = "/addCourseWork")
    public String toaddCourseWork(){
        return "student/addCourseWork";
    }

    @PostMapping(value = "/addCourseWork")
    public String addCourseWork(Coursework c){
        int rows=courseWorkMapper.updateWork(c);
        return "redirect:/coursework/findAllCourseWork";
    }

    @RequestMapping("/deleteCourseWorkById/{uploadId}")
    public String deleteCourseWorkById(@PathVariable String uploadId, HttpServletRequest request){
        int rows=courseWorkMapper.retructWork(uploadId);
        String contextPath=request.getContextPath();
        return "redirect:/coursework/findAllCourseWork";
    }

    @RequestMapping("/findCourseWorkByuploadId/{uploadId}")
    public String CourseWorkByuploadId(@PathVariable("uploadId") String uploadId,Model model){
        System.out.println(uploadId);
        Coursework c=courseWorkMapper.findWorkByUploadId(uploadId);
        model.addAttribute("c",c);
        System.out.println(c);
        return "student/updateCourseWorks";
    }

    @RequestMapping("/updateCourseWork")
    public String updateCourseWork(Coursework c){
        System.out.println(c);
        int rows=courseWorkMapper.updateWork(c);
        return "redirect:/coursework/findAllCourseWork";
    }

    @GetMapping("/toUpload")
    public String toUpload(){
        return "/upload";
    }
    //2040706101 杨艾琳
    @PostMapping("/toUpload")
    public String uploadFile(@RequestParam("uploadFile")List<MultipartFile> uploadFile, HttpSession session, HttpServletRequest request){
// 判断所上传文件是否存在
        if (!uploadFile.isEmpty() && uploadFile.size() > 0) {
            //循环输出上传的文件
            for (MultipartFile file : uploadFile) {
                // 获取上传文件的原始名称
                String originalFilename = file.getOriginalFilename();
                //设置上传文件的保存地址目录
                //String dirPath =request.getServletContext().getRealPath("/upload/");
                // String dirPath =request.getSession().getServletContext().getRealPath("/upload") ;
                String dirPath=request.getRealPath("/upload");
                System.out.println(dirPath);

                File filePath = new File(dirPath);
                // 如果保存文件的地址不存在，就先创建目录
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
//2040706101 杨艾琳
                // 使用UUID重新命名上传的文件名称(上传人_uuid_原始文件名称)
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
}
