package com.jxf.learnspb.jwt;

import com.alibaba.fastjson.JSON;
import com.jxf.learnspb.controller.auth.BaseTransferEntity;
import com.jxf.learnspb.controller.auth.SimpleObject;
import com.jxf.learnspb.util.Base64SecurityAction;
import com.jxf.learnspb.util.MD5Util;
import org.junit.Test;

import java.util.Date;

public class JwtTest {
    @Test
    public void generator(){
        String salt = "jjxxff";

        SimpleObject so = new SimpleObject();
        so.setAaa(1);
        so.setBbb(2.3);
        so.setCcc("ccc");
        so.setDdd(new Date());

        String jsonString = JSON.toJSONString(so);
        String encode = new Base64SecurityAction().doAction(jsonString);
        String md5 = MD5Util.encrypt(encode + salt);

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
        baseTransferEntity.setObject(encode);
        baseTransferEntity.setSign(md5);
        System.out.println(JSON.toJSONString(baseTransferEntity));
    }

}
