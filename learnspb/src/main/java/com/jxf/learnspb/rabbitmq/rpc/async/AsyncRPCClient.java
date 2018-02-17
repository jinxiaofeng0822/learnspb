package com.jxf.learnspb.rabbitmq.rpc.async;

import static com.jxf.learnspb.rabbitmq.config.RpcRabbitConfig.QUEUE_ASYNC_RPC;
import static com.jxf.learnspb.rabbitmq.config.RpcRabbitConfig.QUEUE_ASYNC_RPC_WITH_FIXED_REPLY;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class AsyncRPCClient {

	private static final Logger log = LoggerFactory.getLogger(AsyncRPCClient.class);

	@Autowired
	AsyncRabbitTemplate asyncRabbitTemplate;

	@Autowired
	AmqpTemplate amqpTemplate;

	@Async
	public Future<String> sendAsync(String message) {
		log.info("进入AsyncRPCClient。sendAsync message：" + message);
		String result = (String) amqpTemplate.convertSendAndReceive(QUEUE_ASYNC_RPC, message);
		log.info("进入AsyncRPCClient。sendAsync result：" + result);
		return new AsyncResult<String>(result);
	}

	public Future<String> sendWithFixedReplay(String message) {
		ListenableFuture<String> future = asyncRabbitTemplate.convertSendAndReceive(QUEUE_ASYNC_RPC_WITH_FIXED_REPLY,
				message);
		return future;
	}
}
