package com.github.web.service.impl;

import com.github.web.entity.Transaction;
import com.github.web.mapper.TransactionMapper;
import com.github.web.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author peach
 * @since 2019/7/9 下午8:34
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public Transaction get(Integer id) {
        return transactionMapper.selectById(id);
    }

    @Override
    public int add(Transaction transaction) {
        return transactionMapper.insert(transaction);
    }

    @Override
    public int update(Transaction transaction) {
        return transactionMapper.update(transaction);
    }

    @Override
    public int delete(Integer id) {
        return transactionMapper.delete(id);
    }
}
