package com.github.java8.defaultmethod;

interface MyInterface {
    default void test(){
        System.out.println("test1");
    }
}

interface MyInterface2 {
    default void test(){
        System.out.println("test2");
    }
}

class MyClass implements MyInterface,MyInterface2{
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.test();
    }

    @Override
    public void test() {
        MyInterface2.super.test();
    }
}
