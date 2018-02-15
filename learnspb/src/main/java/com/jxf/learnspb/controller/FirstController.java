package com.jxf.learnspb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jxf.learnspb.dao.NewtbMapper;
import com.jxf.learnspb.entity.Newtb;

@RestController
public class FirstController {

	private static Logger log = LoggerFactory.getLogger(FirstController.class);

	@Autowired
	private NewtbMapper mapper;
	
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
}
