package com.jxf.learnspb.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloReceiver {
	private static Logger log = LoggerFactory.getLogger(HelloReceiver.class);
	
	@RabbitHandler
	@RabbitListener(queues = "hello")
	public void process(String hello){
		System.out.println("HelloReceiver:{}"+hello);
		log.info("HelloReceiver:{}",hello);
	}
}
