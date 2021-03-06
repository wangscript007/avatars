package com.wlgdo.avatar.web.user;

import com.alibaba.dubbo.config.annotation.Reference;

import com.wlgdo.avatar.common.http.HttpResp;
import com.wlgdo.avatar.dubbo.response.Result;
import com.wlgdo.avatar.dubbo.service.IUserService;
import com.wlgdo.avatar.dubbo.users.User;
import com.wlgdo.avatar.web.configure.kafka.KafkaProducer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Value("enable-auto-commit")
    public String Kafka_Enable_Auto_Commit;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Reference
    private IUserService userService;

    @ExceptionHandler
    @RequestMapping("index")
    public Object index() {
        Result<User> result = userService.getUser();
        return HttpResp.instance().setData(result.getObject());
    }

    @GetMapping("list")
    public Object list(@PathVariable int pageNo, @PathVariable int pageSize) {
        return userService.getList(pageNo, pageSize);
    }

    @RequestMapping("msg/{msg}")
    public Object getMessage(@PathVariable String msg) {
        logger.info("开始发送消息{}", msg);
        boolean isOk = false;
        if (StringUtils.isNotBlank(msg)) {
            isOk = KafkaProducer.instance().send(msg);
        }
        return new HttpResp(isOk);
    }
}
