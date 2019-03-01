package com.github.web.service;

import com.github.web.entity.Person;

import java.util.List;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/21 16:21
 * @Version 1.0
 */
public interface PersonService {

    /**
     * 查询person
     * @param id :
     * @return com.github.web.entity.Person
     * @throws
     */
    Person findById(Integer id);
    /**
     * 添加person
     * @param person :
     * @return int
     * @throws
     */
    boolean add(Person person);
    /**
     * 查询所有
     * @return java.util.List<com.github.web.entity.Person>
     * @throws
     */
    List<Person> findAll();
}
