package com.github.web.transaction.chain.controller;

import com.github.web.transaction.chain.entity.Order;
import com.github.web.transaction.chain.service.CustomerService;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 *
 * 链式事务：可以实现不同事务管理器之间的事务同步，
 *       比如：{@link DataSourceTransactionManager}, {@link JpaTransactionManager}, {@link JmsTransactionManager} 等
 *
 * 两个mysql数据源的分布式事务测试（链式事务）
 *
 * 数据源配置 {@link com.github.web.config.DataSourceConfig}
 *
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/8/9 16:20
 */
@RestController
public class CustomerController {
    @Resource(name = "customerServiceImpl2")
    private CustomerService customerService;

    @PostMapping(value = "/order")
    public void createOrder(Order order) {
        customerService.createOrder(order);
    }


    @GetMapping(value = "/userInfo")
    public Map userInfo(Long customerId) {
        return customerService.userInfo(customerId);
    }
}
