package com.dozerstudy.demo.publish;

import com.dozerstudy.demo.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender implements RabbitTemplate.ConfirmCallback {
    @Autowired
    RabbitTemplate template;

//    public void send(String context) {
//        template.convertAndSend(RabbitConfig.EXCHANGE, "", context);
//        template.setConfirmCallback(this);
//    }

    public void send(String context) {
        template.convertAndSend(RabbitConfig.EXCHANGE_TIOPIC, "weather-routingKey.test", context);
        template.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println(" 回调id:" + correlationData);
        if (b) {
            System.out.println("消息成功消费");
        } else {
            System.out.println("消息消费失败:" + s);
        }
    }
}