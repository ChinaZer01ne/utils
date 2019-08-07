package com.github.web.service.impl;

import com.github.web.entity.Transaction;
import com.github.web.mapper.TransactionMapper;
import com.github.web.service.TransactionTwoWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 不使用@transactional注解，手动的方式，相当于aop代理执行的内容
 * @author Zer01ne
 * @version 1.0
 * @date 2019/8/7 15:14
 */
@Service("transactionInAnnotationService")
public class TransactionInAnnotationServiceImpl implements TransactionTwoWayService {



    @Autowired
    private TransactionMapper transactionMapper;

    @Transactional
    @Override
    public String add(Integer id){

        Transaction transaction = new Transaction();
        transaction.setName("annotation");

        transactionMapper.insert(transaction);

        if (id == 1){
            throw new IllegalArgumentException();
        }

        return "finished";
    }

}
