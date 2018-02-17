package com.jxf.learnspb.rabbitmq.rpc.sync;

import java.util.concurrent.Future;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import static com.jxf.learnspb.rabbitmq.config.RpcRabbitConfig.QUEUE_SYNC_RPC;

@Component
public class RPCClient {
	@Autowired
	AmqpTemplate amqpTemplate;
	
	public String send(String message) {
		System.out.println("进入RPCClient.send");
		String result = (String) amqpTemplate.convertSendAndReceive(QUEUE_SYNC_RPC, message);
		System.out.println("进入RPCClient.send result "+result);
		return result;
	}

	@Async
	public Future<String> sendAsync(String message) {
		return new AsyncResult<String>(send(message));
	}
}
