package com.example.service;

import com.example.entity.News;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class TopicsReceiver1 {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("topic-news-queue1"),exchange = @Exchange(value = "annotation-topic-exchange",type = "topic")
            ,key = "news.#.queue1.#"
    ))
    public void receiverQueue1(News news){
        System.out.println("来自队列1："+news);
    }
}
