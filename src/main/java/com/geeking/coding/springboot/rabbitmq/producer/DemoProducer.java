package com.geeking.coding.springboot.rabbitmq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * User: devils
 * Date: 2018/12/11
 */
@Component
public class DemoProducer implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback{

    private static final Logger logger = LoggerFactory.getLogger(DemoProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbit.config.exchange-name}")
    private String exchangeName;

    @Value("${rabbit.config.routingkey.name}")
    private String routingkeyName;


    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    /**
     * 用于实现消息发送到RabbitMQ交换器后接收ack回调。
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        // 消息回调确认失败处理
        if (!ack) {
            logger.info("消息发送失败,causedBy :{}", cause);
        } else {
            logger.info("消息发送成功,消息ID:{}", correlationData.getId());
        }
    }

    /**
     * 用于实现消息发送到RabbitMQ交换器，但无相应队列与交换器绑定时的回调。
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        logger.error("MQ消息发送失败，replyCode:{}, replyText:{}，exchange:{}，routingKey:{}，消息体:{}",
                replyCode, replyText, exchange, routingKey, message.getBody());
    }

    public void send(String message){
        CorrelationData  correlationId = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(exchangeName, routingkeyName, message, correlationId);
    }

}
