package com.dozerstudy.demo.config;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RabbitConfig {
    public static final String EXCHANGE = "spring-fanout-exchange";
    public static final String EXCHANGE_TIOPIC = "spring-topic-exchange";


    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses("127.0.0.1:5672");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPublisherConfirms(true); //必须要设置
        return connectionFactory;
    }

    @Bean
    public Queue queue() {
        return new Queue("spring-queue", true); //队列持久
    }

    @Bean
    public Queue queue2() {
        return new Queue("spring-queue2", true); //队列持久
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE);
    }

    @Bean
    public SimpleMessageListenerContainer messageContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(queue());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                byte[] body = message.getBody();
                System.out.println("receive msg b: " + new String(body));

                channel.basicAck(message.getMessageProperties().getDeliveryTag(), true); //确认消息成功消费

            }
        });
        return container;
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE_TIOPIC);
    }

    @Bean
    public SimpleMessageListenerContainer messageContainer2() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(queue2());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                byte[] body = message.getBody();
                System.out.println("receive msg a: " + new String(body));
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), true); //确认消息成功消费


            }
        });
        return container;
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(fanoutExchange());
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(fanoutExchange());
    }

    @Bean
    public Queue queue_Topic() {
        return new Queue("spring-topic-queue", true); //队列持久
    }

    @Bean
    public Queue queue_Topic1() {
        return new Queue("spring-topic-queue1", true); //队列持久
    }


    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }

    public static final String ROUTINGKEY1 = "weather-routingKey.*";


    @Bean
    public Binding binding_Topic() {
        return BindingBuilder.bind(queue_Topic()).to(topicExchange()).with(ROUTINGKEY1);
    }

    @Bean
    public Binding binding_Topic1() {
        return BindingBuilder.bind(queue_Topic1()).to(topicExchange()).with(ROUTINGKEY2);
    }

    public static final String ROUTINGKEY2 = "msg-routingKey.#";


    @Bean
    public SimpleMessageListenerContainer messageContainer_Topic() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(queue_Topic());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                byte[] body = message.getBody();
                System.out.println("receive topic msg b: " + new String(body));

                channel.basicAck(message.getMessageProperties().getDeliveryTag(), true); //确认消息成功消费

            }
        });
        return container;
    }

    @Bean
    public SimpleMessageListenerContainer messageContainer_Topic1() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(queue_Topic1());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                byte[] body = message.getBody();
                System.out.println("receive  topic1 msg b: " + new String(body));

                channel.basicAck(message.getMessageProperties().getDeliveryTag(), true); //确认消息成功消费

            }
        });
        return container;
    }
}