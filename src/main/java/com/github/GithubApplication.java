package com.github;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/27 14:20
 * @Version 1.0
 */
@MapperScan("com.github.web.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class GithubApplication {
    public static void main(String[] args) {
        SpringApplication.run(GithubApplication.class, args);
    }
    @Autowired
    private ResourceHttpRequestHandler resourceHttpRequestHandler;

    @Bean
    public ResourceHttpRequestHandler resourceHttpRequestHandler(){
        //spring默认不支持post转发
        resourceHttpRequestHandler.setSupportedMethods("POST","GET","HEAD");
        return resourceHttpRequestHandler;
    }

    @Bean
    public SimpleUrlHandlerMapping simpleUrlHandlerMapping(){
        SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
        simpleUrlHandlerMapping.setDefaultHandler(resourceHttpRequestHandler());
        //设置优先级
        simpleUrlHandlerMapping.setOrder(1);

        return simpleUrlHandlerMapping;
    }

    @Autowired
    private SolrClient solrClient;
    @Bean
    public SolrTemplate solrTemplate(){
        return new SolrTemplate(solrClient);
    }
}
