package com.github.java8;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Function{

    void test();

    String toString();
    int hashCode();
    boolean equals(Object obj);
    //void test2();

    default void defaultMethod(){
        System.out.println("This is a default method!");
    }

    static void staticMethod(){
        System.out.println("This is a static method!");
    }
}

public class FunctionalInterfaceTest {

    void testFunction(Function function){
        System.out.println(1);
        function.test();
        System.out.println(2);
    }
    public static void main(String[] args) {
        FunctionalInterfaceTest test = new FunctionalInterfaceTest();
        test.testFunction(()->{
            System.out.println("peach");
        });

        Function function = () -> {
            System.out.println("还能这么玩？ 卧槽。。");
        };

        System.out.println(function);
        System.out.println(function.getClass().getSuperclass());
        System.out.println(function.getClass().getInterfaces()[0]);

        java.util.function.Function<String, String> stringBiFunction = String::toUpperCase;

        List<String> list = Arrays.asList("Hello","world","peach");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
