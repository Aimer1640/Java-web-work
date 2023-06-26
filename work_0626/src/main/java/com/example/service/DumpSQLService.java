package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DumpSQLService {
    @Autowired
    private SendEmailService sendEmailService;

    @Value("${spring.mail.username}")
    private String from;

    //数据库备份方法
    public void dataBaseDump(String host, String port, String username, String password, String dbName, String currentDate) throws Exception {
        //定义备份路径文件夹
        String path="E:/database/";
        File f=new File(path);
        //如果该文件夹不存在，就自己创建
        if (!f.exists()){
            f.mkdir();
        }

        //创建当前备份数据库的.sql文件，名称后面加上当前时间
        File datafile = new File(path+dbName+currentDate+".sql");

        //如果.sql文件已经存在，则结束程序并输出提示信息
        if (datafile.exists()) {
            System.out.println(dbName+"_"+currentDate+ "文件名已存在，请更换");
            return;
        }
        //拼接备份的cmd命令
        String cmd="cmd /c mysqldump -h" + host + " -P" + port + " -u " + username + " -p" + password + " " + dbName +" tb_project"+ " > " + datafile;
        System.out.println("what"+cmd);
        Process exec = Runtime.getRuntime().exec(cmd);

        //备份成功，发送邮件
        sendEmailService.sendSimpleEmail(from,"2806987816@qq.com",currentDate+"每日作业数据备份",dbName+"备份数据库成功!");

        //输出备份成功提醒
        System.out.println("备份成功");

    }

    //开启定时任务支持
    //每分钟备份一次

//    @Scheduled(cron = "0 * * * * *")
//    public void dump() throws Exception {
//        String currentDate=(new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss")).format(new Date());
//        dataBaseDump("localhost","3306","root","root","javawebwork",currentDate);
//
//    }
}