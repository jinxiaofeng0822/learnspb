package com.jxf.learnspb.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

	final static String LOG_DEBUG = "log.debug";
	final static String LOG_INFO = "log.info";

	@Bean
	public Queue logDebug() {
		return new Queue(TopicRabbitConfig.LOG_DEBUG);
	}

	@Bean
	public Queue logInfo() {
		return new Queue(TopicRabbitConfig.LOG_INFO);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange("topicExchange");
	}

	@Bean
	Binding bindingExchangeLogDebug(Queue logDebug, TopicExchange exchange) {
		return BindingBuilder.bind(logDebug).to(exchange).with("log.#");
	}

	@Bean
	Binding bindingExchangeLogInfo(Queue logInfo, TopicExchange exchange) {
		return BindingBuilder.bind(logInfo).to(exchange).with("log.info");
	}
}
