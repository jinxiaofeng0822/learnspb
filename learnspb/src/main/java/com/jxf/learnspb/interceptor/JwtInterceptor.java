package com.jxf.learnspb.interceptor;

import com.alibaba.fastjson.JSON;
import com.jxf.learnspb.config.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(JwtInterceptor.class);

    @Autowired
    private JwtProperties jwtProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进入自定义拦截器");
        final String requestHeader = request.getHeader("Authorization");
        String authToken = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);

            //验证token是否过期,包含了验证jwt是否正确
            try {
                Claims claim = getClaimFromToken(authToken);
                log.info("claim转为json字符串,{}",JSON.toJSONString(claim));
                Date expiration = claim.getExpiration();
                Date now = new Date();
                if(now.after(expiration)){
                    log.info("token已过期");
                    return false;
                }

//                if (flag) {
//                    RenderUtil.renderJson(response, new ErrorTip(BizExceptionEnum.TOKEN_EXPIRED.getCode(), BizExceptionEnum.TOKEN_EXPIRED.getMessage()));
//                    return false;
//                }
            } catch (JwtException e) {
                //有异常就是token解析失败
                log.error("token解析失败",e);
                return false;
            }
        } else {
            //header没有带Bearer字段
            log.info("header开头错误");
            return false;
        }
        log.info("jwt正常结束");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 获取jwt的payload部分
     */
    public Claims getClaimFromToken(String token) {
        return Jwts.parser()
                .setSigningKey("jxfSecret")
                .parseClaimsJws(token)
                .getBody();
    }
}
