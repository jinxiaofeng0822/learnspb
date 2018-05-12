package com.jxf.learnspb.util;

import org.springframework.util.Base64Utils;

/**
 * 对数据进行base64编码的方式
 *
 * @author fengshuonan
 * @date 2017-09-18 20:43
 */
public class Base64SecurityAction {

    public String doAction(String beProtected) {
        return Base64Utils.encodeToString(beProtected.getBytes());
    }

    public String unlock(String securityCode) {
        byte[] bytes = Base64Utils.decodeFromString(securityCode);
        return new String(bytes);
    }
}
