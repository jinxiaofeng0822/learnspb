package com.jxf.learnspb.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jxf.learnspb.rabbitmq.fanout.FanoutSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqFanoutTest {
	@Autowired
    private FanoutSender fanoutSender;
	
	@Test
	public void fanout(){
		fanoutSender.send("fanout第一次发送");
		fanoutSender.send("fanout第二次发送");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
