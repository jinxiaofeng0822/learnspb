package com.jxf.learnspb.rabbitmq.rpc.sync;

import static com.jxf.learnspb.rabbitmq.config.RpcRabbitConfig.QUEUE_SYNC_RPC;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RPCServer {

	@RabbitHandler
	@RabbitListener(queues = QUEUE_SYNC_RPC)
	public String process(String message) {
		System.out.println("进入RPCServer。process message " + message);
		int millis = (int) (Math.random() * 2 * 1000);
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
		return message + " sleep for " + millis + " ms";
	}

	public static void main(String[] args) {
		System.out.println(Math.random());
	}
}
