package com.github.web.dao;

import com.github.web.entity.Person;

import java.util.List;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/21 16:55
 * @Version 1.0
 */
public interface PersonDao {
    List<Person> selectAll();
}
