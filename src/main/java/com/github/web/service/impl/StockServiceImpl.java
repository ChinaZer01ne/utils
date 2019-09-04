package com.github.web.service.impl;

import com.github.web.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/9/4 9:41
 */
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    @Qualifier("userJdbcTemplate")
    private JdbcTemplate userJdbcTemplate;

    @Transactional(rollbackFor = Exception.class,transactionManager = "stockTansactionManager")
    @Override
    public void decrStock() {
        userJdbcTemplate.execute("update stock set count = count - 1 where id = 1");
        int i = 1/0;

    }
}
