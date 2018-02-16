package com.jxf.learnspb.rabbitmq;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {

	private static Logger log = LoggerFactory.getLogger(HelloSender.class);

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "hello " + new Date();
		log.info("Sender : {}", context);
		this.rabbitTemplate.convertAndSend("hello", context);
	}
}
