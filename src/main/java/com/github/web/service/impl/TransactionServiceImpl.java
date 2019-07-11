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
    public int addWithRequired(Transaction transaction) {

        /**
         * 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
         */
        int insert = subTransactionService.addWithRequired(transaction);

        System.out.println(insert);

        if (insert > 0){
            throw new RuntimeException("回滚测试");
        }

        return insert;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateWithSupports(Transaction transaction) {

        /**
         * 支持当前事务，如果当前没有事务，就以非事务方式执行。
         */
        int update = subTransactionService.updateWithSupports(transaction);

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
    public int deleteWithMandatory(Integer id) {
        /**
         * 使用子事务，如果当前没有事务，就抛出异常。
         * */
        int delete = subTransactionService.deleteWithMandatory(id);
        //
        //System.out.println(delete);
        //
        //if (delete == 1){
        //    throw new RuntimeException("删除回滚测试");
        //}

        return delete;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteWithNotSupported(Integer id) {
        /**
         * 以非事务方式执行操作，如果调用者存在事务，就把调用者事务挂起
         * */
        int delete = subTransactionService.deleteWithNotSupported(id);

        throw new RuntimeException("删除回滚测试");

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteWithRequiresNew(Integer id) {
        /**
         * 开启新事务，若调用者已有事务存在，挂起调用者事务：当执行子事务的时候，父事务挂起，子事务执行完，父事务继续
         * */
        int delete = subTransactionService.deleteWithRequiresNew(id);

        throw new RuntimeException("删除回滚测试");

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteWithNested(Integer id) {
        /**
         * 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
         * */
        int delete = subTransactionService.deleteWithNested(id);

        throw new RuntimeException("删除回滚测试");

    }

    //@Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteWithNever(Integer id) {
        /**
         * 如果调用者存在事务，则抛出异常
         * */
        int delete = subTransactionService.deleteWithNever(id);

        throw new RuntimeException("删除回滚测试");
    }
}
