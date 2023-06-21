package com.example.controller;

import com.example.mapper.CourseWorkMapper;
import com.example.pojo.Coursework;

import com.example.util.PageUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/coursework")
public class CourseWorkController {
    @Resource
    private CourseWorkMapper courseWorkMapper;
    @RequestMapping("/findAllCourseWork")
    public String findAllCourseWork(@RequestParam Map<String, String> map, Model model){
        if (map.size() == 0 || map.get("currentPage").isEmpty()) {
            map.put("currentPage", "1");
        }
        // 从数据库中查询出信息
        List<Coursework> courseworks=courseWorkMapper.findAllWork();
        PageUtil pageInfo = new PageUtil(Integer.valueOf(map.get("currentPage")), 3, courseworks);
        model.addAttribute("courseworkList", pageInfo.getList());
        System.out.println("pageInfo:"+pageInfo);
        System.out.println("courseworks"+courseworks);
        model.addAttribute("pageInfo", pageInfo);
        return "public/showAllCourseWork";
    }

    @GetMapping(value = "/addCourseWork")
    public String toaddCourseWork(){
        return "student/addCourseWork";
    }

    @PostMapping(value = "/addCourseWork")
    public String addCourseWork(Coursework c,MultipartFile file,HttpSession session, HttpServletRequest request){
        System.out.println("uploadFile:"+file);
        String dirPath=request.getServletContext().getRealPath("/upload/");
        File filePath=new File(dirPath);
        // 指定上传文件本地存储目录，不存在需要提前创建
        if (!filePath.exists()){
            filePath.mkdirs();
        }
        //上传文件
        String originalFileName=file.getOriginalFilename();
//        System.out.println("name:"+originalFileName);

        //UUID重命名上传文件名
//        String newFileName= UUID.randomUUID()+"_"+originalFileName;

        try {
            file.transferTo(new File(dirPath+originalFileName));
        }
        catch (Exception e) {
            return "error";
        }
        c.setUploadFile(originalFileName);
        c.setState("1");
        System.out.println("name:"+originalFileName);
        int rows=courseWorkMapper.uploadWork(c);
        System.out.println("add c:"+c);
        return "redirect:/coursework/findAllCourseWork";
    }

    @RequestMapping("/deleteCourseWorkById")
    public String deleteCourseWorkById(String uploadId, HttpServletRequest request){
        int rows=courseWorkMapper.retructWork(uploadId);
        System.out.println(uploadId);
        String contextPath=request.getContextPath();
        return "redirect:/coursework/findAllCourseWork";
    }

    @RequestMapping("/findCourseWorkByuploadId")
    public String CourseWorkByuploadId(String uploadId,Model model){
        System.out.println(uploadId);
        Coursework c=courseWorkMapper.findWorkByUploadId(uploadId);
        model.addAttribute("c",c);
        System.out.println(c);
        return "student/updateCourseWorks";
    }

    @RequestMapping("/updateCourseWork")
    public String updateCourseWork(Coursework c,MultipartFile file,HttpSession session, HttpServletRequest request){
        System.out.println("uploadFile:"+file);
        String dirPath=request.getServletContext().getRealPath("/upload/");
        File filePath=new File(dirPath);
        // 指定上传文件本地存储目录，不存在需要提前创建
        if (!filePath.exists()){
            filePath.mkdirs();
        }
        //上传文件
        String originalFileName=file.getOriginalFilename();
//        System.out.println("name:"+originalFileName);

        //UUID重命名上传文件名
//        String newFileName= UUID.randomUUID()+"_"+originalFileName;

        try {
            file.transferTo(new File(dirPath+originalFileName));
        }
        catch (Exception e) {
            return "error";
        }
        c.setUploadFile(originalFileName);
        c.setState("2");
        System.out.println("name:"+originalFileName);

        System.out.println("coursework:"+c);
        int rows=courseWorkMapper.updateWork(c);
        System.out.println(c.getState());
        return "redirect:/coursework/findAllCourseWork";
    }

    // 所有类型文件下载管理
    @RequestMapping("/download")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request,
                                               String filename) throws Exception{
        // 指定要下载的文件根路径
        String dirPath = request.getSession().getServletContext().getRealPath("/upload/");
        System.out.println(dirPath);
        // 创建该文件对象
        File file = new File(dirPath + File.separator + filename);
        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        // 通知浏览器以下载方式打开（下载前对文件名进行转码）
        filename=getFilename(request,filename);
        headers.setContentDispositionFormData("attachment",filename);
        // 定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try {
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(e.getMessage().getBytes(), HttpStatus.EXPECTATION_FAILED);
        }
    }
    // 根据浏览器的不同进行编码设置，返回编码后的文件名
    private String getFilename(HttpServletRequest request, String filename)
            throws Exception {
        // IE不同版本User-Agent中出现的关键词
        String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};
        // 获取请求头代理信息
        String userAgent = request.getHeader("User-Agent");
        for (String keyWord : IEBrowserKeyWords) {
            if (userAgent.contains(keyWord)) {
                //IE内核浏览器，统一为UTF-8编码显示，并对转换的+进行更正
                return URLEncoder.encode(filename, "UTF-8").replace("+"," ");
            }
        }
        //火狐等其它浏览器统一为ISO-8859-1编码显示
        return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
    }

}
