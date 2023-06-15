package com.example.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {
    //接收news-queue1test队列消息
    @RabbitListener(queues = "news-queue1test")
    public void receiveQueue1(Message message){
        byte[] body= message.getBody();
        String s=new String(body);
        System.out.println("收到一条队列消息:"+s);
    }

}
