package com.github.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.web.dao.PersonDao;
import com.github.web.entity.Person;
import com.github.web.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/21 16:21
 * @Version 1.0
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private PersonDao personDao;
    @Cacheable(value = "reidsCache",key = "'person' + #id")
    @Override
    public Person findById(Integer id) {
        return null;
    }

    @CacheEvict(value = "reidsCache",allEntries = true)
    @Override
    public boolean add(Person person) {
        return false;
    }

    /**
     * 解决高并发下热点缓存问题
     * */
    @Override
    public List<Person> findAll() {

        String personList = redisTemplate.boundValueOps("produce").get();

        if (StringUtils.isEmpty(personList)){
            //这时候其他线程可能刚刚添加完缓存
            synchronized (this){
                //阻塞之后，去一次，如果其他线程可刚刚添加完缓存，就能取到了
                personList = redisTemplate.boundValueOps("produce").get();

                if (StringUtils.isEmpty(personList)){
                    //如果还没有查到，就从数据库中获取
                    List<Person> people = personDao.selectAll();
                    personList = JSONObject.toJSONString(people);
                    redisTemplate.boundValueOps("produce").set(personList);
                }
            }
        }
        return JSON.parseArray(personList, Person.class);
    }
}
