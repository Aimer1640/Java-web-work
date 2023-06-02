package com.example.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.net.URLEncoder;
import java.util.UUID;

@Controller("/freshman")
public class FreshmanController {
    @RequestMapping("/login")
    public String toLogin(){
        return "freshman";
    }
    @RequestMapping("/toUpload")
    public String toUpload(){
        return "myUpload";
    }

    @RequestMapping("/upload")
    public String uploadFile(MultipartFile zkz, MultipartFile sfz, MultipartFile tzs, HttpSession session, HttpServletRequest request){
        String dirPath=request.getServletContext().getRealPath("/upload/");
        File filePath=new File(dirPath);
        // 指定上传文件本地存储目录，不存在需要提前创建
        if (!filePath.exists()){
            filePath.mkdirs();
        }
        //上传文件
        String originalFileName=zkz.getOriginalFilename();
        String originalFileName2=sfz.getOriginalFilename();
        String originalFileName3=tzs.getOriginalFilename();
        //UUID重命名上传文件名
        String newFileName= UUID.randomUUID()+"_"+originalFileName;
        String newFileName2= UUID.randomUUID()+"_"+originalFileName2;
        String newFileName3= UUID.randomUUID()+"_"+originalFileName3;
        try {
            zkz.transferTo(new File(dirPath+newFileName));
            sfz.transferTo(new File(dirPath+newFileName2));
            tzs.transferTo(new File(dirPath+newFileName3));
            }
        catch (Exception e) {
            return "error";
            }
        return "myInfoFile";
    }

//    @PostMapping("/uploadFile")
//    public String uploadFile(MultipartFile[] fileUpload, Model model) {
//        // 默认文件上传成功，并返回状态信息
//        model.addAttribute("uploadStatus", "上传成功！");
//        for (MultipartFile file : fileUpload) {
//            // 获取文件名以及后缀名
//            String fileName = file.getOriginalFilename();
//            // 重新生成文件名（根据具体情况生成对应文件名）
//            //fileName = UUID.randomUUID()+"_"+fileName;
//            // 指定上传文件本地存储目录，不存在需要提前创建
//            String dirPath = "F:/files/";
//
//            File filePath = new File(dirPath);
//            if(!filePath.exists()){
//                filePath.mkdirs();
//            }
//            try {
//                file.transferTo(new File(dirPath+fileName));
//            } catch (Exception e) {
//                e.printStackTrace();
//                // 上传失败，返回失败信息
//                model.addAttribute("uploadStatus","上传失败： "+e.getMessage());
//            }
//        }
//        // 携带上传状态信息回调到文件上传页面
//        return "upload";
//    }

    @RequestMapping("/toDownloadReport")
    public String toDownloadReport(){
        return "downloadReport";
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
