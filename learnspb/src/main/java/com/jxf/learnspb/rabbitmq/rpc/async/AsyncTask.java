package com.jxf.learnspb.rabbitmq.rpc.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class AsyncTask {
	private final static Logger log = LoggerFactory.getLogger(AsyncTask.class);

	@Async
	public ListenableFuture<String> expensiveOperation(String message) {
		
		int millis = (int) (Math.random() * 5 * 1000);
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
		String result = message + " executed by " + Thread.currentThread().getName() + " for " + millis + " ms";
		return new AsyncResult<String>(result);
	}
}
