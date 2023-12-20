package com.sinor.backend.websocket.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeConfig {
    private static final String TOPIC_EXCHANGE_NAME = "amq.topic";
    private static final String FANOUT_EXCHANGE_NAME = "amq.fanout";

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    @Bean
    public FanoutExchange pubsubExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE_NAME);
    }
}
