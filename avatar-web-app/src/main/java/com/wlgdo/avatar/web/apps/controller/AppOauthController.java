package com.wlgdo.avatar.web.apps.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Author: Ligang.Wang[wlgchun@l63.com]
 * Date: 2019/8/18 23:10
 */
@Slf4j
@Controller
public class AppOauthController {

    private static String redirect_uri = "http://www.wlgdo.com/oauth";
    private static String client_id = "189881679c4983dd7ae6";
    private static String client_secret = "1fbf8e8f67933b28d075fc77af7c10a3a14d7f0d";
    private static String ACCESS_TOKEN_URL = "https://github.com/login/oauth/access_token?client_id=189881679c4983dd7ae6&client_secret=1fbf8e8f67933b28d075fc77af7c10a3a14d7f0d&redirect_uri=http://www.wlgdo.com/oauth&code=2f5ca04906e841b4e8e3&state=213844c9-bbd6-4016-9b1c-94776a24e3a8";
//    private static String ACCESS_TOKEN_URL = "https://github.com/login/oauth/access_token?client_id=189881679c4983dd7ae6&client_secret=1fbf8e8f67933b28d075fc77af7c10a3a14d7f0d&redirect_uri=http://www.wlgdo.com/oauth&code=2f5ca04906e841b4e8e3&state=213844c9-bbd6-4016-9b1c-94776a24e3a8";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("oauth/github")
    public Object callback(String code, String access_token, String scope, HttpServletResponse response) {

        log.info("获取到的token是: [{} , {}]", code, scope);

        if (StringUtils.isNotBlank(code)) {



        }

//        response.sendRedirect(redirect_uri + "?access_token=" + MD5Encoder.encode(userInfo.getPassword().getBytes("UTF-8")));
        return "";
    }

}
