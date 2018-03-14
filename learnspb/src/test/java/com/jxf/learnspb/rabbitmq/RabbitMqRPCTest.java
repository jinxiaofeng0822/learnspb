package com.jxf.learnspb.rabbitmq;

import com.jxf.learnspb.rabbitmq.rpc.sync.RPCClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqRPCTest {

    @Autowired
    private RPCClient rpcClient;

    @Test
    public void rpc(){
        rpcClient.send("20180314");
    }
}
