package com.github.web.service.impl;

import com.github.web.entity.Transaction;
import com.github.web.mapper.TransactionMapper;
import com.github.web.service.SubTransactionService;
import com.github.web.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事务嵌套测试
 * @author peach
 * @since 2019/7/9 下午8:34
 */
@Service
public class TransactionServiceImpl implements TransactionService {


    @Autowired
    private SubTransactionService subTransactionService;

    @Override
    public Transaction get(Integer id) {
        return subTransactionService.get(id);
    }

    @Override
    public int add(Transaction transaction) {

        /**
         * 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
         */
        int insert = subTransactionService.add(transaction);

        System.out.println(insert);

        if (insert > 0){
            throw new RuntimeException("回滚测试");
        }

        return insert;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int update(Transaction transaction) {

        /**
         * 支持当前事务，如果当前没有事务，就以非事务方式执行。
         */
        int update = subTransactionService.update(transaction);

        System.out.println(update);

        if (update > 0){
            //transaction.setId(10);
            //transaction.setName("update and insert");
            //transaction.setVersion("1.0");
            //subTransactionService.add(transaction);
            throw new RuntimeException("回滚测试");
        }
        //
        //throw new RuntimeException("没有对应的数据");

        return update;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int delete(Integer id) {
        /**
         * 使用子事务，如果当前没有事务，就抛出异常。
         * */
        int delete = subTransactionService.delete(id);
        //
        //System.out.println(delete);
        //
        //if (delete == 1){
        //    throw new RuntimeException("删除回滚测试");
        //}

        return delete;
    }
}
