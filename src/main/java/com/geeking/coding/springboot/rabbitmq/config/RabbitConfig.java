package com.geeking.coding.springboot.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * User: devils
 * Date: 2018/12/11
 */
@Configuration
public class RabbitConfig {


    @Value("${rabbit.config.queue-name}")
    private String queueName;

    @Value("${rabbit.config.exchange-name}")
    private String exchangeName;

    @Value("${rabbit.config.routingkey-name}")
    private String routingkeyName;

    @Bean
    public Queue queue(){
        return new Queue(queueName);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(topicExchange()).with(routingkeyName);
    }

}
