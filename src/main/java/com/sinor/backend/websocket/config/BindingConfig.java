package com.sinor.backend.websocket.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BindingConfig {

    private final Queue defaultQueue;
    private final TopicExchange topicExchange;
    private final FanoutExchange fanoutExchange;

    @Autowired
    public BindingConfig(Queue defaultQueue, TopicExchange topicExchange, FanoutExchange fanoutExchange) {
        this.defaultQueue = defaultQueue;
        this.topicExchange = topicExchange;
        this.fanoutExchange = fanoutExchange;
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(defaultQueue)
                .to(topicExchange)
                .with("hello.key.#");
    }

    @Bean
    public Binding pubsubBinding() {
        return BindingBuilder
                .bind(defaultQueue)
                .to(fanoutExchange);
    }

}
