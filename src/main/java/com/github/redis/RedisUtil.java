package com.github.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisUtil {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Resource(name="stringRedisTemplate")
    ValueOperations<String,String> valOpsStr;

    @Resource(name="redisTemplate")
    ValueOperations<Object,Object> valOpsObj;

    public String getStr(String key){
        return valOpsStr.get(key);
    }


    public void setStr(String key, String value){
        valOpsStr.set(key,value);
    }

    public void delStr(String key){
        stringRedisTemplate.delete(key);
    }

    public Object getObj(Object o){
        return valOpsObj.get(o);
    }

    public void setObj(Object o1, Object o2){
        valOpsObj.set(o1,o2);
    }

    public void delObj(Object key){
        redisTemplate.delete(key);
    }
}
