package com.sinor.backend.websocket;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class RabbitMQProducer {

	@Value("${rabbitmq.exchange.name}")
	private String exchange;

	@Value("${rabbitmq.routing.key}")
	private String routingKey;
	private final RabbitTemplate rabbitTemplate;

	// @Autowired
	public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@GetMapping("/publish")
	public void sendMessage(String message) {
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
		log.info(String.format("[x] Message sent -> %s", message));
	}
}
