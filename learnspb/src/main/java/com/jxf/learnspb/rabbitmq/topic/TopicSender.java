package com.jxf.learnspb.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TopicSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "hi, i am log.1";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "log.1", context);
	}

	public void send1() {
		String context = "hi, i am log.info";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "log.info", context);
	}

	public void send2() {
		String context = "hi, i am log.debug";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "log.debug", context);
	}

}