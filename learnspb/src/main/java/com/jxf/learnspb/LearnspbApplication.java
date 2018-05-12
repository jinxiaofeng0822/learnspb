package com.jxf.learnspb;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

import java.math.BigInteger;
import java.nio.charset.Charset;

@SpringBootApplication
public class LearnspbApplication {
//	@Bean
//	public HttpMessageConverters fastJsonHttpMessageConverters() {
//		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//		FastJsonConfig fastJsonConfig = new FastJsonConfig();
//		fastJsonConfig.setSerializerFeatures(
//				SerializerFeature.PrettyFormat,
//				SerializerFeature.WriteMapNullValue,
//				SerializerFeature.WriteEnumUsingToString
//		);
//		fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
//		fastJsonConfig.setCharset(Charset.forName("utf-8"));
//
//		//解决Long转json精度丢失的问题
//		SerializeConfig serializeConfig = SerializeConfig.globalInstance;
//		serializeConfig.put(BigInteger.class, ToStringSerializer.instance);
//		serializeConfig.put(Long.class, ToStringSerializer.instance);
//		serializeConfig.put(Long.TYPE, ToStringSerializer.instance);
//		fastJsonConfig.setSerializeConfig(serializeConfig);
//		fastConverter.setFastJsonConfig(fastJsonConfig);
//		HttpMessageConverter<?> converter = fastConverter;
//		return new HttpMessageConverters(converter);
//	}

	public static void main(String[] args) {
		SpringApplication.run(LearnspbApplication.class, args);
	}
}
