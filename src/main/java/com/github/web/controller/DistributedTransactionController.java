package com.github.web.controller;

import com.github.web.service.DistributedTransactionService;
import com.github.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/9/4 9:34
 */
@RestController
@RequestMapping("/distributed/tx")
public class DistributedTransactionController {

    @Autowired
    private DistributedTransactionService distributedTransactionService;

    @RequestMapping("/createOrder")
    public void createOrder(){
        distributedTransactionService.saveOrder();
    }
}
