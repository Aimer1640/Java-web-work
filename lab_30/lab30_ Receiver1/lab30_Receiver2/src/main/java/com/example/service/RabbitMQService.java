package com.example.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {
    //接收news-queue2test队列消息
    @RabbitListener(queues = "news-queue2test")
    public void receiveQueue2(Message message){
        byte[] body= message.getBody();
        String s=new String(body);
        System.out.println("收到一条队列消息:"+s);
    }

}
