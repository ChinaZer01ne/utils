package com.github.utils.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.AbstractHandlerMethodMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import java.util.Objects;

/**
 * @Author: Zer01ne
 * @Date: 2019/1/16 9:46
 * @Version 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer,BeanPostProcessor {

}
