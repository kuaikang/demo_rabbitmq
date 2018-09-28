package com.example.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: kuaik
 * @Date: 2018-09-28
 * @Description:
 */
@Component
@RabbitListener(containerFactory = "containerFactory", queues = "hello")
public class TestListener {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @RabbitHandler
    public void handler(String message) {
        System.out.println("内容：" + message + ",时间：" + simpleDateFormat.format(new Date()));
    }
}