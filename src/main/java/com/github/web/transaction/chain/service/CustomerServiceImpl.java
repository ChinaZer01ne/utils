package com.github.web.transaction.chain.service;

import com.github.web.transaction.chain.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

 * @author Zer01ne
 * @version 1.0
 * @date 2019/8/9 16:15
 */
@Service("customerServiceImpl2")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    @Qualifier("userJdbcTemplate")
    private JdbcTemplate userJdbcTemplate;

    @Autowired
    @Qualifier("orderJdbcTemplate")
    private JdbcTemplate orderJdbcTemplate;

    private static final String SQL_UPDATE_DEPOSIT = "UPDATE customer SET deposit = deposit - ? WHERE id = ? ";
    private static final String SQL_CREATE_ORDER = "INSERT INTO customer_order(customerId,title,amount) VALUE(?,?,?)";

    /**
     * 使用Transactional在一个方法中，会使用设施默认的连接池的事务
     * 并不能早证两个事务的一致性
     * @param order
     */
    @Override
    @Transactional(transactionManager = "userTansactionManager")
    public void createOrder(Order order) {
        userJdbcTemplate.update(SQL_UPDATE_DEPOSIT, order.getAmount(), order.getCustomerId());
        if (order.getTitle().contains("error1")) {
            throw new RuntimeException("Error1");
        }
        orderJdbcTemplate.update(SQL_CREATE_ORDER, order.getCustomerId(), order.getTitle(), order.getAmount());
        if (order.getTitle().contains("error2")) {
            throw new RuntimeException("Error2");
        }
    }
    @Override
    public Map userInfo(Long customerId) {
        Map<String, Object> customerMap = userJdbcTemplate.queryForMap("SELECT * FROM customer");
        List<Map<String, Object>> orders = orderJdbcTemplate.queryForList("SELECT * FROM customer_order");

        Map result = new HashMap();
        result.put("customer", customerMap);
        result.put("orders", orders);
        return result;
    }
}
