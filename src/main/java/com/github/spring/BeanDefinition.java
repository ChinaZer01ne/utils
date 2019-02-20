package com.github.spring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/14 11:15
 * @Version 1.0
 */
public class BeanDefinition {
    private String beanId;
    private String className;

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
