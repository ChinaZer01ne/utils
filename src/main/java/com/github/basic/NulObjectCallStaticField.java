package com.github.basic;

/**
 * null对象可以调用static域和方法
 * @Author: Zer01ne
 * @Date: 2019/2/25 17:53
 * @Version 1.0
 */
public class NulObjectCallStaticField {

    private static final Integer A = 1;

    public static void print(){
        System.out.println("null object can call static method!");
    }
    public static void main(String[] args) {
        NulObjectCallStaticField nullObject = null;
        System.out.println(nullObject.A);
        nullObject.print();
    }
}
