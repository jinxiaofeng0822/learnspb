package com.jxf.learnspb.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	@Bean
	public Queue hello(){
		return new Queue("hello");
	}
	
	@Bean
	public Queue many(){
		return new Queue("many");
	}
}
