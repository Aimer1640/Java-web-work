package com.example;

import com.example.entity.News;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Lab30SenderApplication implements CommandLineRunner {
    @Autowired
    private AmqpAdmin amqpAdmin;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Lab30SenderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //消息发送组件
        //交换器
        amqpAdmin.declareExchange(new FanoutExchange("news-exchangetest"));
        //定义两个队列
        amqpAdmin.declareQueue(new Queue("news-queue1test"));
        amqpAdmin.declareQueue(new Queue("news-queue2test"));
        //将交换器与队列绑定
        amqpAdmin.declareBinding(new Binding("news-queue1test",Binding.DestinationType.QUEUE,"news-exchangetest","",null));
        amqpAdmin.declareBinding(new Binding("news-queue2test",Binding.DestinationType.QUEUE,"news-exchangetest","",null));

        //发送消息到两个队列
        News news=new News();
        news.setNewsId(1);
        news.setCnewsContent("新闻1");
        news.setNewsTitle("今年夏天为什么这么热");
//        news.setNewsId(2);
//        news.setCnewsContent("新闻2");
//        news.setNewsTitle("好热好好热好热");
        news.setPublishTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        rabbitTemplate.convertAndSend("news-exchangetest","",news);
    }
}
