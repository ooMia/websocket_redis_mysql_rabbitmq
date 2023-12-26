package com.sinor.backend.websocket;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class RabbitMQConsumer {
	public void consume(String message) {
		log.info(String.format("Received message -> %s", message));
	}
}
