package com.github.web.controller;

import com.github.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/21 11:34
 */
@RestController
public class RedisTestController {

    @Autowired
    private RedisUtil redisUtil;


    @RequestMapping("/redis")
    public String redis(){
        redisUtil.setStr("test","redis");
        return redisUtil.getStr("test");
    }
}
