package com.example.demo.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
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
    public void handler(String message, Channel channel,@Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        System.out.println();
        for (int i = 0; i < 1000; i++) {
            System.out.print("1");
        }
        System.out.println();
        System.out.println("消费者------------->内容：" + message + ",时间：" + simpleDateFormat.format(new Date()));

        try {
            /* 手动确认*/
            channel.basicAck(tag,false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
