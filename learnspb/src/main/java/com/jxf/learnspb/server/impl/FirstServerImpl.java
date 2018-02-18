package com.jxf.learnspb.server.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.jxf.learnspb.dao.mapper.learnspb.NewtbMapper;
import com.jxf.learnspb.entity.Newtb;
import com.jxf.learnspb.server.FirstServer;

@Service("firstServer")
public class FirstServerImpl implements FirstServer{
	
	private static Logger log = LoggerFactory.getLogger(FirstServerImpl.class);

	@Autowired
	private NewtbMapper mapper;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Override
	public String select() {
		String asdf = stringRedisTemplate.opsForValue().get("asdf");
		log.info("一开始进入asdf的值是{}",asdf);
		if(asdf!=null){
			log.info("asdf不为空");
			return asdf;
		}else{
			log.info("asdf是空的===========");
			Newtb tb = mapper.selectByPrimaryKey(8);
			stringRedisTemplate.opsForValue().set("asdf", tb.getAsDf());
			return tb.getAsDf();
		}
	}

}
