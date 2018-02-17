package com.jxf.learnspb.rabbitmq.rpc.async;

import static com.jxf.learnspb.rabbitmq.config.RpcRabbitConfig.QUEUE_ASYNC_RPC;
import static com.jxf.learnspb.rabbitmq.config.RpcRabbitConfig.QUEUE_ASYNC_RPC_WITH_FIXED_REPLY;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class AsyncRPCServer {
	@Autowired
	AmqpTemplate amqpTemplate;

	@Autowired
	AsyncTask asyncTask;

	private static final Logger log = LoggerFactory.getLogger(AsyncRPCServer.class);

	@RabbitListener(queues = QUEUE_ASYNC_RPC)
	public void process(String message, @Header(AmqpHeaders.REPLY_TO) String replyTo) {
		log.info("recevie message {} and reply to {}", message, replyTo);
		if (replyTo.startsWith("amq.rabbitmq.reply-to")) {
			log.debug("starting with version 3.4.0, the RabbitMQ server now supports Direct reply-to");
		} else {
			log.info("fall back to using a temporary reply queue");
		}
		ListenableFuture<String> asyncResult = asyncTask.expensiveOperation(message);
		asyncResult.addCallback(new ListenableFutureCallback<String>() {
			@Override
			public void onSuccess(String result) {
				log.info("AsyncRPCServer.process.onSuccess result:{}",result);
				amqpTemplate.convertAndSend(replyTo, result);
			}

			@Override
			public void onFailure(Throwable ex) {
				log.error("AsyncRPCServer.process.onFailure",ex);
			};
		});
	}

	@RabbitListener(queues = QUEUE_ASYNC_RPC_WITH_FIXED_REPLY)
	public void process(String message, @Header(AmqpHeaders.REPLY_TO) String replyTo,
			@Header(AmqpHeaders.CORRELATION_ID) byte[] correlationId) {
		log.info("进入{}。process",QUEUE_ASYNC_RPC_WITH_FIXED_REPLY);
		log.info("消息内容massage是{}",message);
		log.info(
				"use a fixed reply queue {}, it is necessary to provide correlation data {} so that replies can be correlated to requests",
				replyTo, new String(correlationId));
		ListenableFuture<String> asyncResult = asyncTask.expensiveOperation(message);
		asyncResult.addCallback(new ListenableFutureCallback<String>() {
			@Override
			public void onSuccess(String result) {
				/*
				 * Message resultMessage =
				 * MessageBuilder.withBody(result.getBytes())
				 * .setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
				 * .setCorrelationId(correlationId) .build();
				 * amqpTemplate.send(replyTo, resultMessage);
				 */
				amqpTemplate.convertAndSend(replyTo, (Object) result, new MessagePostProcessor() {
					@Override
					public Message postProcessMessage(Message message) throws AmqpException {
						// https://stackoverflow.com/questions/42382307/messageproperties-setcorrelationidstring-is-not-working
						message.getMessageProperties().setCorrelationId(correlationId);
						return message;
					}
				});
			}

			@Override
			public void onFailure(Throwable ex) {

			};
		});
	}
}
