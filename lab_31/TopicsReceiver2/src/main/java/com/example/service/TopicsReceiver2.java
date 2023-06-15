package com.example.service;

import com.example.entity.News;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class TopicsReceiver2 {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("topic-news-queue2"),exchange = @Exchange(value = "annotation-topic-exchange",type = "topic")
            ,key = "news.#.queue2.#"
    ))
    public void receiverQueue2(News news){
        System.out.println("来自队列2："+news);
    }
}
