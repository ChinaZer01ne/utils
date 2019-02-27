package com.github.web.dao;

import com.github.web.mapper.PersonMapper;
import com.github.web.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/21 16:55
 * @Version 1.0
 */
@Service
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<Person> selectAll() {
        return personMapper.selectAll();
    }
}
