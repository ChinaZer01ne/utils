package com.github.web.service.impl;

import com.github.web.entity.Transaction;
import com.github.web.mapper.TransactionMapper;
import com.github.web.service.SubTransactionService;
import com.github.web.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author peach
 * @since 2019/7/9 下午8:34
 */
@Service
public class SubTransactionServiceImpl implements SubTransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public Transaction get(Integer id) {
        return transactionMapper.selectById(id);
    }

    /**
     * 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
     */
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    @Override
    public int addWithRequired(Transaction transaction) {
        int insert = transactionMapper.insert(transaction);
        if (insert > 0){
            throw new RuntimeException("子事务异常");
        }
        return insert;
    }

    /**
     * 支持当前事务，如果当前没有事务，就以非事务方式执行。
     */
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.SUPPORTS)
    @Override
    public int updateWithSupports(Transaction transaction) {

        return transactionMapper.update(transaction);
    }

    /**
     * 使用子事务，如果当前没有事务，就抛出异常。
     * */
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.MANDATORY)
    @Override
    public int deleteWithMandatory(Integer id) {

        return transactionMapper.delete(id);
    }

    /**
     * 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
     * */
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.NOT_SUPPORTED)
    @Override
    public int deleteWithNotSupported(Integer id) {

        return transactionMapper.delete(id);
    }

    /**
     * 开启新事务，若调用者已有事务存在，挂起调用者事务：当执行子事务的时候，父事务挂起，子事务执行完，父事务继续
     * */
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    @Override
    public int deleteWithRequiresNew(Integer id) {

        return transactionMapper.delete(id);
    }
    /**
     * 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
     * */
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.NESTED)
    @Override
    public int deleteWithNested(Integer id) {

        return transactionMapper.delete(id);
    }
    /**
     * 以非事务方式执行，如果调用者存在事务，则抛出异常
     * */
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.NEVER)
    @Override
    public int deleteWithNever(Integer id) {

        return transactionMapper.delete(id);
    }
}
