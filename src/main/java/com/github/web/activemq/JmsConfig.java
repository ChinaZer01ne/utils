package com.github.web.activemq;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.jms.ConnectionFactory;

/**
 * @author peach
 * @since 2019/8/7 下午9:59
 */
@EnableJms
@Configuration
public class JmsConfig {

    /**
     * 外部事务：使用JmsTransactionManager管理事务
     */
    @Bean
    public PlatformTransactionManager transactionManager(ConnectionFactory connectionFactory){
        return new JmsTransactionManager(connectionFactory);
    }

    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory){
        return new JmsTemplate(connectionFactory);
    }

    @Bean
    public JmsListenerContainerFactory<?> msgFactory(ConnectionFactory connectionFactory,
                                                     PlatformTransactionManager platformTransactionManager,
                                                     DefaultJmsListenerContainerFactoryConfigurer configurer){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory,connectionFactory);
        factory.setReceiveTimeout(10000L);
        factory.setCacheLevelName("CACHE_CONNECTION");
        factory.setTransactionManager(platformTransactionManager);
        return factory;
    }
}
