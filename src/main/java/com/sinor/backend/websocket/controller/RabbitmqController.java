package com.sinor.backend.websocket.controller;

import com.sinor.backend.websocket.model.RabbitMessage;
import com.sinor.backend.websocket.publisher.RabbitPublisher;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitmqController {

    private final RabbitPublisher rabbitPublisher;

    @Autowired
    public RabbitmqController(RabbitPublisher rabbitPublisher) {
        this.rabbitPublisher = rabbitPublisher;
    }

    @GetMapping("/send")
    public void sendMessage() {
        IntStream.range(0, 2).forEachOrdered(n -> {
            RabbitMessage rabbitMessage = new RabbitMessage(String.valueOf(n), "First Name" + n, "Last Name" + n);
            rabbitPublisher.sendMessage(rabbitMessage);
        });
    }

    /**
     * PubSub 테스트용
     */
    @PostMapping("/pubsub")
    public void pubsubMessage() {

        IntStream.range(0, 2).forEachOrdered(n -> {
            RabbitMessage rabbitMessage = new RabbitMessage(String.valueOf(n), "First Name" + n, "Last Name" + n);
            rabbitPublisher.pubsubMessage(rabbitMessage);
        });
    }
}
