package com.geeking.coding.springboot.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * User: devils
 * Date: 2018/12/11
 */
@Configuration
public class DemoConsumer {


    private static final Logger logger = LoggerFactory.getLogger(DemoConsumer.class);

    @RabbitListener(queues = {"${rabbit.config.queue-name}"})
    public void process(Message message){
        String body = Arrays.toString(message.getBody());
        logger.info("received message:{}" ,body);
        MessageProperties properties = message.getMessageProperties();

    }


}
