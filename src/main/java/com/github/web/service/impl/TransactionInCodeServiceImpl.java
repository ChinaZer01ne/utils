package com.github.web.service.impl;

import com.github.web.entity.Transaction;
import com.github.web.mapper.TransactionMapper;
import com.github.web.service.TransactionTwoWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 不使用@transactional注解，手动的方式，相当于aop代理执行的内容
 * @author Zer01ne
 * @version 1.0
 * @date 2019/8/7 15:14
 */
@Service("transactionInCodeService")
public class TransactionInCodeServiceImpl implements TransactionTwoWayService {


    @Autowired
    private PlatformTransactionManager platformTransactionManager;
    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public String add(Integer id){

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();

        def.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = platformTransactionManager.getTransaction(def);


        try {
            Transaction transaction = new Transaction();
            transaction.setName("code");
            transactionMapper.insert(transaction);
            //测试回滚
            if (id == 1){
                throw new IllegalArgumentException();
            }

            platformTransactionManager.commit(status);
            return "success";
        }catch (Exception e){
            platformTransactionManager.rollback(status);
            return "fail to rollback";
        }

    }

}
