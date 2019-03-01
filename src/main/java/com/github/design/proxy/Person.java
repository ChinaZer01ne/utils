package com.github.design.proxy;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/13 13:42
 * @Version 1.0
 */
public class Person implements Animal {

    private String name = "递归人";
    @Override
    public void eat() {
        System.out.println("吃饭。。。");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
