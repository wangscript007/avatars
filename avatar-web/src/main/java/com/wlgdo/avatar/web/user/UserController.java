package com.wlgdo.avatar.web.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wlgdo.avatar.dubbo.common.PageInfo;
import com.wlgdo.avatar.dubbo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(getClass());

    //private RedisTemplate<String, String> redisTemplate;

    @Reference
    private IUserService userService;

    @RequestMapping("index")
    public Object index() {
        String uname = userService.getUserName();

        logger.info("user`s name is:{}", uname);
        return "welcome to you:" + (StringUtils.isEmpty(uname) ? "helloworld" : uname);
    }

    @RequestMapping("list/{pageNo}/{pageSize}")
    public Object list(@PathVariable int pageNo, @PathVariable int pageSize) {
        PageInfo page = userService.getList(pageNo, pageSize);
        return page;
    }

    public Object getUserInfo(){

        return null;
    }
}
