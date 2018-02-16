package com.jxf.learnspb.rabbitmq.many;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "many")
public class Receiver1 {
	
private static Logger log = LoggerFactory.getLogger(Receiver1.class);
	
	@RabbitHandler
	public void process(String hello){
		log.info("Receiver1:{}",hello);
	}
}
