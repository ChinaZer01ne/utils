package com.github.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.DefaultErrorViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

@SpringBootApplication
public class UtilsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtilsApplication.class, args);
    }

    @Autowired
    private ResourceHttpRequestHandler resourceHttpRequestHandler;

    @Bean
    public ResourceHttpRequestHandler resourceHttpRequestHandler(){
        resourceHttpRequestHandler.setSupportedMethods("POST","GET","HEAD");
        return resourceHttpRequestHandler;
    }

    @Bean
    public SimpleUrlHandlerMapping simpleUrlHandlerMapping(){
        SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
        simpleUrlHandlerMapping.setDefaultHandler(resourceHttpRequestHandler());
        simpleUrlHandlerMapping.setOrder(1);

        return simpleUrlHandlerMapping;
    }
}
