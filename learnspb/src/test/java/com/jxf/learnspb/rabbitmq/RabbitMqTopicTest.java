package com.jxf.learnspb.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jxf.learnspb.rabbitmq.fanout.FanoutSender;
import com.jxf.learnspb.rabbitmq.topic.TopicSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTopicTest {
	@Autowired
    private TopicSender ts;
	
	@Test
	public void fanout(){
		ts.send1();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
