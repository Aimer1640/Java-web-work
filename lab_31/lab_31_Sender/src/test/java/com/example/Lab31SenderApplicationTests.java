package com.example;

import com.example.entity.News;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class Lab31SenderApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    void contextLoads() {
        News news=new News();
        news.setNewsId(4);
        news.setCnewsContent("新闻4");
        news.setNewsTitle("今天为什么这么热");
        news.setPublishTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        rabbitTemplate.convertAndSend("annotation-fanout-exchange","",news);

    }
    @Test
    void topicTest(){
        News news=new News();
        news.setNewsId(5);
        news.setCnewsContent("新闻5");
        news.setNewsTitle("今天好热");
        rabbitTemplate.convertAndSend("annotation-topic-exchange","news.queue1",news);

    }
}
