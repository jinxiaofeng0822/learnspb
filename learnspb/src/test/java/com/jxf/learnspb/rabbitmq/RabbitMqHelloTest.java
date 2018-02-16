package com.jxf.learnspb.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jxf.learnspb.rabbitmq.many.Sender1;
import com.jxf.learnspb.rabbitmq.many.Sender2;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {    
    @Autowired
    private HelloSender helloSender;    
   
    @Autowired
    private Sender1 sender1;
    @Autowired
    private Sender2 sender2;
    
    @Test
    public void hello() throws Exception {
        helloSender.send();
    }
    
    @Test
    public void oneToMany(){
    	for (int i = 0; i < 200; i++) {
    		sender1.send("这是sender1的第"+i+"条消息");
    		sender2.send("这是sender2的第"+i+"条消息");
		}
    }

}
