package com.sinor.backend.websocket;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Receiver {

	private final CountDownLatch latch = new CountDownLatch(1);
	private MessageConverter messageConverter;
	private ObjectMapper objectMapper;

	@Autowired
	public Receiver(MessageConverter messageConverter, ObjectMapper objectMapper) {
		this.messageConverter = messageConverter;
		this.objectMapper = objectMapper;
	}


	public void receiveMessage(byte[] received) throws IOException {
		String message = new String(received, StandardCharsets.UTF_8);
		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
		Message message1 = messageConverter.toMessage(message, messageProperties);
		String message2 = (String)messageConverter.fromMessage(message1);

		System.out.println(message1);
		System.out.println(message2);
		latch.countDown();
	}

}