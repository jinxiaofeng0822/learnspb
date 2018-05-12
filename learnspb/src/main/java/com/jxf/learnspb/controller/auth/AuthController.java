package com.jxf.learnspb.controller.auth;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jxf.learnspb.util.MD5Util;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取令牌
 */
@RestController
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @RequestMapping(value = "${jwt.auth-path}")
    public String createAuthenticationToken() {
        SimpleObject so = new SimpleObject();
        so.setAaa(123);
        so.setBbb(654.987);
        so.setCcc(null);
        so.setDdd(new Date());

        Map<String, Object> claims = new HashMap<>();
        claims.put("randomKey", "jjxxff");

        Date date = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("tsy")
                .setIssuedAt(new Date())
                .setAudience("userName")
                .setSubject("user")
                .setExpiration(new Date(date.getTime() + 24 * 60 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS512, "jxfSecret")
                .compact();
    }

    @RequestMapping("/hello")
    public String hello(@RequestBody SimpleObject so) {
        log.info("str:{}", JSON.toJSONString(so));
        JSONObject jo = new JSONObject();
        jo.put("zzz", "aaa");
        return jo.toString();
    }

    public static void main(String[] args) {
        String s = "123";
        System.out.println(MD5Util.encrypt(s));
    }
}
