package com.github.web.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/8/9 15:26
 */
@Data
@Configuration
@PropertySource("classpath:application-transaction-multi.properties")
@Component
public class DataSourceConfig {


    /**
     * db，如果配置了多数据源，就需要配置一个主要的数据源
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource dataSource(){
        return dataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }
    /**
     * 多数据源配置需要指定以哪一个数据源构造模板
     * */
    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    /**
     * 测试多数据源的分布式事务
     */
    /**
     * db_user
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.customized.db1")
    public DataSourceProperties userDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    public DataSource userDataSource(){
        return userDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    /**
     * {@link com.github.web.activemq.JmsConfig},之前测试的时候配置过PlatformTransactionManager，所以得加这个注解 @Primary
     */
    //@Primary
    public PlatformTransactionManager userTansactionManager(){
        DataSourceTransactionManager userTM = new DataSourceTransactionManager(userDataSource());
        DataSourceTransactionManager orderTM = new DataSourceTransactionManager(orderDataSource());
        //链式事务
        ChainedTransactionManager chainedTransactionManager = new ChainedTransactionManager(userTM,orderTM);
        return chainedTransactionManager;
    }
    /**
     * 测试分布式事务
     * 事务的回滚需要相应的事务管理器
    @Bean
    public PlatformTransactionManager stockTansactionManager(){
        return new DataSourceTransactionManager(userDataSource());

    }
    @Bean
    public PlatformTransactionManager orderTansactionManager(){
        return new DataSourceTransactionManager(orderDataSource());

    }
    @Bean
    public PlatformTransactionManager testTansactionManager(){
        return new DataSourceTransactionManager(dataSource());

    }
     * */
    @Primary
    @Bean
    public PlatformTransactionManager testTansactionManager(){
        return new DataSourceTransactionManager(dataSource());

    }

    /**
     *
     * JpaTransactionManager 和 DataSourceTransactionManager的链式事务
     *
     @Bean
     public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
         HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
         vendorAdapter.setGenerateDdl(false);

         LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
         factoryBean.setJpaVendorAdapter(vendorAdapter);
         factoryBean.setDataSource(userDataSource());
         factoryBean.setPackagesToScan("");
         return factoryBean;
     }
     @Bean
     @Primary
     public PlatformTransactionManager userTansactionManager(){
         JpaTransactionManager userTM = new JpaTransactionManager();
         userTM.setEntityManagerFactory(entityManagerFactoryBean().getObject());
         PlatformTransactionManager orderTM = new DataSourceTransactionManager(orderDataSource());
         //链式事务
         ChainedTransactionManager chainedTransactionManager = new ChainedTransactionManager(userTM,orderTM);
         return chainedTransactionManager;
     }
     * */

    /**
     * 多数据源配置需要指定以哪一个数据源构造模板
     * */
    @Bean
    public JdbcTemplate userJdbcTemplate(@Qualifier("userDataSource") DataSource userDataSource){
        return new JdbcTemplate(userDataSource);
    }


    /**
     * db_order
     */

    @Bean
    @ConfigurationProperties(prefix = "spring.customized.db2")
    public DataSourceProperties orderDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    public DataSource orderDataSource(){
        return orderDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }
    /**
     * 多数据源配置需要指定以哪一个数据源构造模板
     * */
    @Bean
    public JdbcTemplate orderJdbcTemplate(@Qualifier("orderDataSource") DataSource orderDataSource){
        return new JdbcTemplate(orderDataSource);
    }

}
