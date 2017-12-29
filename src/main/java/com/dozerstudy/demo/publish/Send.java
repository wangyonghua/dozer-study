//package com.dozerstudy.demo.publish;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.support.CorrelationData;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.UUID;
//
//@Component
//public class Send {
//    private RabbitTemplate rabbitTemplate;
//
//    /**
//     * 构造方法注入
//     */
//    @Autowired
//    public Send(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//        rabbitTemplate.setConfirmCallback(new Accept()); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
//    }
//
//    public void sendMsg(String content) {
//        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
//        rabbitTemplate.convertAndSend(AmqpConfig.EXCHANGE, AmqpConfig.ROUTINGKEY, content, correlationId);
//    }
//
//
//}