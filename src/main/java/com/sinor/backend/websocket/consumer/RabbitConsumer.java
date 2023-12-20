package com.sinor.backend.websocket.consumer;


import com.sinor.backend.websocket.model.RabbitMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitConsumer {

    @RabbitListener(queues = "#{defaultQueue.name}")
    public void consume(RabbitMessage message) {
        log.info("{}", message);
    }

    @RabbitListener(queues = "#{defaultQueue.name}")
    public void consumeSub(RabbitMessage message) {
        log.info("[consumeSub]: {}", message);
    }

}
