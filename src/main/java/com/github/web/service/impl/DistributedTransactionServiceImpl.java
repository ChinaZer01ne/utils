package com.github.web.service.impl;

import com.github.web.entity.Transaction;
import com.github.web.mapper.TransactionMapper;
import com.github.web.service.DistributedTransactionService;
import com.github.web.service.OrderService;
import com.github.web.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/9/4 9:43
 */
@Service
public class DistributedTransactionServiceImpl implements DistributedTransactionService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private StockService stockService;

    @Autowired
    private TransactionMapper transactionMapper;

    @Transactional(rollbackFor = Exception.class,transactionManager = "testTansactionManager")
    @Override
    public void saveOrder() {
        Transaction transaction = new Transaction();
        transaction.setId(2);
        transaction.setName("START");
        transaction.setVersion("ING");
        transactionMapper.update(transaction);
        stockService.decrStock();
        orderService.saveOrder();
    }
}
