package com.example.controller;

import com.example.dao.FreshmanDao;
import com.example.pojo.Freshman;
import com.example.pojo.User;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/freshman")
public class FreshmanController {
    @Resource
    private FreshmanDao freshmanDao;

    @RequestMapping("/toFreshman")
    public String toFreshman(){
        return "freshman/freshman";
    }

    //2040706101 杨艾琳
    @GetMapping("/freshmanUpdate")
    public String updateFreshman(String ticketNumber,Model model){
        Freshman freshman=freshmanDao.findFreshmanByticketNumber(ticketNumber);
        model.addAttribute("freshman",freshman);
        return "freshman/freshmanUpdate";
    }

    @PostMapping("/freshmanUpdate")
    public String updateFreshman(Freshman freshman){
        int rows=freshmanDao.updateFreshman(freshman);
        return "freshman/freshmanUpdate";
    }


    @GetMapping("/toUpload")
    public String toUpload(){
        return "freshman/upload";
    }
//    public String toUpload(String ticketNumber,Model model){
//        Freshman freshman=freshmanDao.findFreshmanByticketNumber(ticketNumber);
//        model.addAttribute("freshman",freshman);
//        return "freshman/upload";
//    }
//2040706101 杨艾琳
    @PostMapping("/toUpload")
    public String uploadFile(@RequestParam("uploadFile")List<MultipartFile> uploadFile, HttpSession session,HttpServletRequest request){
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
                String newFilename = user.getAccount()+ "_"+UUID.randomUUID() +
                        "_"+originalFilename;
                System.out.println(dirPath + File.separator +newFilename);
                try {
                    // 使用MultipartFile接口的方法完成文件上传到指定位置
                    file.transferTo(new File(dirPath +File.separator + newFilename));
                } catch (Exception e) {
                    e.printStackTrace();
                    return "freshman/error";
                }
            }
            // 跳转到成功页面
            return "freshman/myInfoFile";
        }else{
            return"freshman/error";
        }
    }

    @RequestMapping("toDownloadReport")
    public String toDownloadReport(){
        return "freshman/downloadReport";
    }
    //2040706101 杨艾琳
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(String filename,HttpServletRequest request) throws IOException {
        //指定下载目录
        String dirPath=request.getRealPath("/upload");
        //创建下载对象
        File file=new File(dirPath + File.separator +filename);
        //响应头
        HttpHeaders headers = new HttpHeaders();
        //对文件名进行编码
        filename=this.getFilename(request,filename);
        // 通知浏览器以下载的方式打开文件
        headers.setContentDispositionFormData("attachment", filename);
        // 定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 使用Sring MVC框架的ResponseEntity对象封装返回下载数据
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
    }

    public String getFilename(HttpServletRequest request,String filename) throws UnsupportedEncodingException {
        String[] IEKeyWords={"MISE","Trident","Edge"};
//2040706101 杨艾琳
        String userAgent=request.getHeader("User-Agent");
        for (String keyWord:IEKeyWords){
            if (userAgent.contains(keyWord)){
                return URLEncoder.encode(filename,"UTF-8");
            }
        }
        //非ie浏览器
        return new String(filename.getBytes("UTF-8"),"ISO-8859-1");
    }
}