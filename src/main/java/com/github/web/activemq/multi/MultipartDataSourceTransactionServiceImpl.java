package com.github.web.activemq.multi;

import com.github.web.activemq.multi.MultipartDataSourceTransactionService;
import com.github.web.entity.Transaction;
import com.github.web.mapper.TransactionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 测试多数据源的事务处理：MQ + 数据库
 */
@Service
@Slf4j
public class MultipartDataSourceTransactionServiceImpl implements MultipartDataSourceTransactionService {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private TransactionMapper transactionMapper;

    @Transactional
    @Override
    @JmsListener(destination = "customer:msg1:create")
    public void saveAndSend(String msg){

        Transaction transaction = new Transaction();
        transaction.setName("by listener in annotation. msg: " + msg);
        transaction.setVersion("by listener in annotation. msg: " + msg);
        transactionMapper.insert(transaction);

        log.info("Get msg: {}",msg);
        String reply = "Reply- in annotation : " + msg;
        jmsTemplate.convertAndSend("customer:msg:reply",reply);

        if (msg.contains("error")){
            throw new IllegalArgumentException();
        }
    }

    /**
     * 非注解的方式使用事务
     */
    @Override
    public void saveAndSendInCode(String msg){

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        def.setTimeout(15);
        TransactionStatus status = transactionManager.getTransaction(def);

        try {

            Transaction transaction = new Transaction();
            transaction.setName("by listener in annotation. msg: " + msg);
            transaction.setVersion("by listener in annotation. msg: " + msg);
            transactionMapper.insert(transaction);

            log.info("Get msg: {}",msg);
            String reply = "Reply- in code ：" + msg;
            jmsTemplate.convertAndSend("customer:msg:reply",reply);
            if (msg.contains("error")){
                transactionManager.rollback(status);
            }
            transactionManager.commit(status);
        }catch (Exception e){
            transactionManager.rollback(status);
        }

    }

    @Transactional
    @Override
    public String read() {
        //jmsTemplate.setReceiveTimeout(2000);
        Object o = jmsTemplate.receiveAndConvert("customer:msg:reply");
        //设置超时时间，否则连接会耗尽，抛异常，一般项目中，写配置类的时候就应该配置好
        jmsTemplate.setReceiveTimeout(2000);
        System.err.println(String.valueOf(o));
        return String.valueOf(o);
    }

    @Transactional
    @Override
    public void convertAndSend(String s, String msg) {
        jmsTemplate.convertAndSend(s,msg);
    }


}
