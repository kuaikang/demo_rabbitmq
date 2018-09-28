package com.example.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: kuaik
 * @Date: 2018-09-28
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestSendMessageController {

    @Autowired
    RabbitTemplate rabbitTemplate;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @GetMapping("send")
    public String send(String message){
        System.out.println("发送时间:" + simpleDateFormat.format(new Date()));
        rabbitTemplate.convertAndSend("ex","hello.k",message);
        return message;
    }
}