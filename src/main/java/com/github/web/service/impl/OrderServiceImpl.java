package com.github.web.service.impl;

import com.github.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/9/4 9:41
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    @Qualifier("orderJdbcTemplate")
    private JdbcTemplate orderJdbcTemplate;


    @Transactional(rollbackFor = Exception.class,transactionManager = "orderTansactionManager")
    @Override
    public void saveOrder() {
        orderJdbcTemplate.execute("insert into `order` (name) values ('NEW')");
    }
}
