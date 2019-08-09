package com.github.web.transaction.mysql.controller;

import com.github.web.transaction.mysql.entity.Order;
import com.github.web.transaction.mysql.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 *
 *
 * 两个mysql数据源的分布式事务测试
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
