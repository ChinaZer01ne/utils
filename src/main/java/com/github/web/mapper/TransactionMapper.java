package com.github.web.mapper;

import com.github.web.entity.Transaction;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/21 17:26
 * @Version 1.0
 */
@Mapper
@Repository
public interface TransactionMapper {

    @Select("select * from transaction where id = #{id}")
    Transaction selectById(Integer id);

    @Insert("insert into transaction values(#{id},#{name},#{version})")
    int insert(Transaction transaction);


    @Update("update transaction set name = #{name}, version = #{version} where id = #{id}")
    int update(Transaction transaction);

    @Delete("delete from transaction where id = #{id}")
    int delete(Integer id);

    List<Transaction> findAll();
}
