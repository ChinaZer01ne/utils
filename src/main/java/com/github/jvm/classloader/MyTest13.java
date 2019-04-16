package com.github.jvm.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

public class MyTest13 {
    public static void main(String[] args) {
        ServiceLoader<Driver> load = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = load.iterator();
        while (iterator.hasNext()){
            Driver next = iterator.next();
            System.out.println("driver : " + next.getClass() + "，loader : " + next.getClass().getClassLoader());
        }

        System.out.println("context class loader : " + Thread.currentThread().getContextClassLoader());
        System.out.println("service loader class loader : " + load.getClass().getClassLoader());
    }
}
