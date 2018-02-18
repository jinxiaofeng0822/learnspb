package com.jxf.learnspb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jxf.learnspb.dao.mapper.learnspb.NewtbMapper;
import com.jxf.learnspb.dao.mapper.spb2.Tb02Mapper;
import com.jxf.learnspb.entity.Newtb;
import com.jxf.learnspb.entity.Tb02;
import com.jxf.learnspb.server.FirstServer;

@RestController
public class FirstController {

	private static Logger log = LoggerFactory.getLogger(FirstController.class);

	@Autowired
	private NewtbMapper mapper;
	
	@Autowired
	private Tb02Mapper mapper2;
	
	@Autowired
	private FirstServer firstServer;
	
	@RequestMapping(value = "/one", produces = "application/json; charset=utf-8")
	public String one() {
		log.info("这是日志");
		log.debug("这是debug");
		Newtb record = new Newtb();
		record.setAsDf("asdf");
		record.setQwEr("qwer");
		mapper.insertSelective(record);
		return "qaz中文";
	}
	
	@RequestMapping(value = "/tow", produces = "application/json; charset=utf-8")
	public String tow() {
		log.info("数据源2-------------------");
		Tb02 tb = new Tb02();
		tb.setName1("n1");
		tb.setName2("n2");
		mapper2.insertSelective(tb);
		log.info("数据源2执行结束");
		return "数据源2";
	}
	
	@RequestMapping(value = "/select", produces = "application/json; charset=utf-8")
	public String select(){
		return firstServer.select();
	}
}
