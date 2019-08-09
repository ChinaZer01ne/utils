package com.github.web.transaction.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试jta外部事务：多数据源
 *
 * 需要注释掉自定义的TransactionManager的配置{@JmsConfig(测试Jms事务时自己写的)}，默认Spring会配置成JtaTransactionManager
 *
 *
 *
 */
@RestController
@RequestMapping("multipart")
public class MultipartDataSourceController {

    @Autowired
    JmsTemplate jmsTemplate;
    @Autowired
    private MultipartDataSourceTransactionService transactionService;

    @RequestMapping("/msg/listener")
    public String create(@RequestParam("msg") String msg){
        transactionService.convertAndSend("customer:msg1:create",msg);
        return "ok";
    }

    @RequestMapping("/msg/handle")
    public String handle(@RequestParam("msg") String msg){
        transactionService.saveAndSend(msg);
        return "ok";
    }


    @RequestMapping("/msg/read")
    public String read(){
        String result = transactionService.read();

        return result;
    }


}
