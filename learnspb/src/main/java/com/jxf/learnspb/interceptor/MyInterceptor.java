package com.jxf.learnspb.interceptor;

import com.alibaba.fastjson.JSON;
import com.jxf.learnspb.config.JwtTokenUtil;
import com.jxf.learnspb.controller.auth.BaseTransferEntity;
import com.jxf.learnspb.util.Base64SecurityAction;
import com.jxf.learnspb.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(MyInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            log.info("preHandle");
            JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
            String object = request.getParameter("object");
            String sign = request.getParameter("sign");
            String token = request.getHeader("Authorization").substring(7);
            log.info("object:{}",object);
            log.info("sign:{}",sign);
            log.info("token:{}",token);

            Base64SecurityAction base64SecurityAction = new Base64SecurityAction();
            String unlock = base64SecurityAction.unlock(object);
            log.info("unlock:{}",unlock);

            String md5KeyFromToken = jwtTokenUtil.getMd5KeyFromToken(token);
            log.info("md5KeyFromToken:{}",md5KeyFromToken);

            String encrypt = MD5Util.encrypt(object + md5KeyFromToken);
            log.info("jwt,sign:{}",encrypt);

            return true;
        }catch(Exception e){
            log.error("出问题了",e);
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion");
    }
}
