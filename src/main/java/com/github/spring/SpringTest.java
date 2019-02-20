package com.github.spring;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/12 14:34
 * @Version 1.0
 */
public class SpringTest {
    private static BeanFactory beanFactory = new BeanFactory();
    private static List<BeanDefinition> beanDefinitions = new ArrayList<>();
    static {
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanId("girl");
        beanDefinition.setClassName("com.github.spring.Girl");
        beanDefinitions.add(beanDefinition);
        beanFactory.setBeanDefinitions(beanDefinitions);
    }
    public static void main(String[] args) throws Exception {

        Girl girl = (Girl) beanFactory.getBean("girl");
        girl.info();
    }
}
