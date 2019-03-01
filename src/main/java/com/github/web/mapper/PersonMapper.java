package com.github.web.mapper;

import com.github.web.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/21 17:26
 * @Version 1.0
 */
@Mapper
public interface PersonMapper {

    @Select("select * from person")
    List<Person> selectAll();
}
