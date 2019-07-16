package com.github.design.singleton;

public class SingletonExample1 {

    private static SingletonExample1 single = new SingletonExample1();

    private SingletonExample1(){}

    public static SingletonExample1 getInstance(){
        return single;
    }

    public static void main(String[] args) {

    }
}
