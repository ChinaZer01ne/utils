package com.github.web.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Producer
 * @author peach
 * @since 2019/8/7 下午9:23
 */
@RestController
@RequestMapping("activemq")
public class ProducerController {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/msg/listener")
    public void create(@RequestParam("msg") String msg){
        jmsTemplate.convertAndSend("customer:msg1:new",msg);
    }

    @RequestMapping("/msg/handle")
    public void handle(@RequestParam("msg") String msg){
        customerService.handle(msg);
    }

    @RequestMapping("/msg2/listener")
    public void create2(@RequestParam("msg") String msg){
        jmsTemplate.convertAndSend("customer:msg2:new",msg);
    }

    @RequestMapping("/msg2/handle")
    public void handle2(@RequestParam("msg") String msg){
        customerService.handleInCode(msg);
    }

    @RequestMapping("/msg/read")
    public String read(){
        jmsTemplate.setReceiveTimeout(2000);
        Object o = jmsTemplate.receiveAndConvert("customer:msg:reply");
        return String.valueOf(o);
    }
}
