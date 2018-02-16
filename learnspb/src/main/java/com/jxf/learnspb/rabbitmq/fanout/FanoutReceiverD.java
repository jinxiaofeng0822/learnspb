package com.jxf.learnspb.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.C")
public class FanoutReceiverD {

    @RabbitHandler
    public void process(String message) {
        System.out.println("fanout Receiver D: " + message);
    }

}
