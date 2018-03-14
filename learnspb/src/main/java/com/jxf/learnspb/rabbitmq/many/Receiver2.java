package com.jxf.learnspb.rabbitmq.many;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver2 {
private static Logger log = LoggerFactory.getLogger(Receiver2.class);
	
	@RabbitHandler
	@RabbitListener(queues = "many")
	public void process(String hello){
		log.info("Receiver2:{}",hello);
	}
}
