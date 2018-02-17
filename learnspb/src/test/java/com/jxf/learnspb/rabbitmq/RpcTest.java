package com.jxf.learnspb.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jxf.learnspb.rabbitmq.rpc.async.AsyncRPCClient;
import com.jxf.learnspb.rabbitmq.rpc.sync.RPCClient;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RpcTest {
	@Autowired
	RPCClient rpcClient;
	
	@Autowired
	AsyncRPCClient asyncRpcClient;
	
//	@Test
	public void rpc(){
//		rpcClient.send("测试rpc");
		rpcClient.sendAsync("测试sendAsync");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void asyncRpc(){
		asyncRpcClient.sendAsync("测试asyncRpc");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
