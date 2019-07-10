package com.github.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Mapper
@Repository
public interface BigDecimalMapper {

    @Select("select money from test where id = 1")
    BigDecimal selectBigDecimal();
}
