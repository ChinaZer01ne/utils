package com.github.web.activemq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 测试 Spring JMS 的内部事务和外部事务
 * @author peach
 * @since 2019/8/7 下午9:23
 */
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Override
    @Transactional(rollbackFor = Exception.class)
    @JmsListener(destination = "customer:msg1:new",containerFactory = "msgFactory")
    public void handle(String msg){
        log.info("Get msg: {}",msg);
        String reply = "Reply-" + msg;
        //session管理的原生事务，只会在该方法内部起作用，而不是作用于整个调用方法
        jmsTemplate.convertAndSend("customer:msg:reply",reply);

        /**
         * 原生事务：
         *      如果通过直接调用的方式，触发了异常，那么消息依然会写入到消息队列中 {@ProducerController#create }
         *          ：session管理的原生事务，只会在该方法内部起作用，而不是作用于整个调用方法
         *      如果通过监听的方式，触发了异常，那么会进行回滚 {@ProducerController#handle }
         *          ：消息的写入与消息的读出处在一个session中，所以能回滚
         *          ：J而直接调用不是
         * 外部事务：
         *      如果想要使用直接调用的方式，也正常回滚消息，
         *      那么可以配置containerFactory来让JmsTranscationManager来个管理session {@JmsConfig}
         *      并且需要在方法上添加@Transactional注解
         * */
        if (msg.contains("error")){
            throw new RuntimeException();
        }
    }

    /**
     * 非注解的方式使用事务
     */
    @Override
    @JmsListener(destination = "customer:msg2:new",containerFactory = "msgFactory")
    public void handleInCode(String msg){

        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(transactionDefinition);

        try {
            log.info("Get msg: {}",msg);
            String reply = "Reply-" + msg;
            //session管理的原生事务，只会在该方法内部起作用，而不是作用于整个调用方法
            jmsTemplate.convertAndSend("customer:msg:reply",reply);
            if (msg.contains("error")){
                transactionManager.rollback(status);
            }
            transactionManager.commit(status);
        }catch (Exception e){
            transactionManager.rollback(status);
        }

    }
}
