package com.sinor.backend.websocket.publisher;

import com.sinor.backend.websocket.model.RabbitMessage;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final FanoutExchange fanoutExchange;
    private final TopicExchange topicExchange;

    @Autowired
    public RabbitPublisher(RabbitTemplate rabbitTemplate, FanoutExchange fanoutExchange, TopicExchange topicExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.fanoutExchange = fanoutExchange;
        this.topicExchange = topicExchange;
    }

    public void sendMessage(RabbitMessage message) {
        rabbitTemplate.convertAndSend(
                topicExchange.getName(),
                "hello.key.1",
                message);
    }

    public void pubsubMessage(RabbitMessage message) {
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", message);
    }

}