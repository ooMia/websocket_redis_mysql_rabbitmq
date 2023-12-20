package com.sinor.backend.websocket.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    private static final String DEFAULT_QUEUE_NAME = "default-queue";

    @Bean
    public Queue defaultQueue() {
        return new Queue(DEFAULT_QUEUE_NAME, false);
    }

}
