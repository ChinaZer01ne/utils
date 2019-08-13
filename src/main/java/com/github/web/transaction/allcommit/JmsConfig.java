package com.github.web.transaction.allcommit;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.connection.TransactionAwareConnectionFactoryProxy;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

/**
 * 事务最大努力一次性提交配置，和链式事务一样，如果在最后一次提交之前关闭数据库，也会出现数据不一致的情况，除此之外，可以保证分布式事务
 * @author peach
 * @since 2019/8/9 下午10:29
 */
//@Configuration
public class JmsConfig {
    /**
     * 使用TransactionAwareConnectionFactoryProxy来完成mq和其他事务管理器事务的同步
     */
    @Bean
    public ConnectionFactory connectionFactory(){
        ConnectionFactory cf = new ActiveMQConnectionFactory();
        TransactionAwareConnectionFactoryProxy proxy = new TransactionAwareConnectionFactoryProxy();
        proxy.setTargetConnectionFactory(cf);
        /**
         * 事务同步设置
         */
        proxy.setSynchedLocalTransactionAllowed(true);
        return proxy;
    }

    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory){
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        /**
         * 设置消息发送在事务中
         */
        jmsTemplate.setSessionTransacted(true);
        return jmsTemplate;
    }
}
