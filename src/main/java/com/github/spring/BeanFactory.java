package com.github.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/14 12:23
 * @Version 1.0
 */

public class BeanFactory {
    List<BeanDefinition> beanDefinitions = new ArrayList<>();

    public Object getBean(String beanId) throws Exception{
        for (BeanDefinition beanDefinition:
             beanDefinitions) {
            if (Objects.equals(beanDefinition.getBeanId(),beanId)){
                Class<?> aClass = Class.forName(beanDefinition.getClassName());
                //aClass.getDeclaredConstructor().newInstance();
                return aClass.newInstance();
            }
        }
        return null;
    }


    public List<BeanDefinition> getBeanDefinitions() {
        return beanDefinitions;
    }

    public void setBeanDefinitions(List<BeanDefinition> beanDefinitions) {
        this.beanDefinitions = beanDefinitions;
    }

}
