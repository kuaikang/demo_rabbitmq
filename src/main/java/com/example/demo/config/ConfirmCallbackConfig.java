package com.example.demo.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: kuaik
 * @Date: 2018-09-28
 * @Description:
 */
@Component
public class ConfirmCallbackConfig implements RabbitTemplate.ConfirmCallback {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        // 只确认是否正确到达Exchange中
        rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("消息唯一标识：" + correlationData);
        System.out.println("确认结果：" + ack);
        System.out.println("失败原因：" + cause);
    }
}
