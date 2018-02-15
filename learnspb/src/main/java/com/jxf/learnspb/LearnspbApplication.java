package com.jxf.learnspb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jxf.learnspb.dao")
public class LearnspbApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnspbApplication.class, args);
	}
}
