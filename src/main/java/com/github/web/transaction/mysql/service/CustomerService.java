package com.github.web.transaction.mysql.service;

import com.github.web.transaction.mysql.entity.Order;

import java.util.Map;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/8/9 16:29
 */
public interface CustomerService {
    void createOrder(Order order);
    Map userInfo(Long customerId);
}
