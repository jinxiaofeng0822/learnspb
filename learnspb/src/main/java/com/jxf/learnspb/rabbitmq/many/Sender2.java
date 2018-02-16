package com.jxf.learnspb.rabbitmq.many;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender2 {
private static Logger log = LoggerFactory.getLogger(Sender2.class);
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send(String sendInfo) {
		this.rabbitTemplate.convertAndSend("many", sendInfo);
	}
}
