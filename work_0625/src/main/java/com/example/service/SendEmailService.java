package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {


    @Autowired
    private JavaMailSenderImpl javaMailSender;
    /**
     * 发送纯文本邮件
     * @param to       收件人地址
     * @param subject  邮件标题
     * @param text     邮件内容
     */
    public void sendSimpleEmail(String from,String to,String subject,String text){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        //发件人
        mailMessage.setFrom(from);
        //邮件信息
        mailMessage.setSubject(subject);

        //收件人
        mailMessage.setTo(to);
        mailMessage.setText(text);
        javaMailSender.send(mailMessage);
        try{
            javaMailSender.send(mailMessage);
            System.out.println("发送成功");
        }catch (MailException e){
            System.out.println("发送失败");
            e.printStackTrace();
        }


    }
}
