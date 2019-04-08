package com.github.java8.function;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * BinaryOperator 是BiFunction的一种特例，输入类型和返回类型一样
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/8 14:03
 */
public class BinaryOperatorTest {

    public static void main(String[] args) {
        System.out.println(add(1, 2, (a, b) -> a + b));
        System.out.println(add(1, 2, (a, b) -> a * b));

        System.out.println("==================");

        System.out.println(getMin("hello","world", Comparator.comparingInt(String::length)));
        System.out.println(getMin("hello","world", (a,b) ->{
            return a.charAt(0) - b.charAt(0);
        }));
    }

    public static int add(int a, int b, BinaryOperator<Integer> operator){
        return operator.apply(a,b);
    }

    public static String getMin(String a,String b, Comparator<String> comparator){
        return BinaryOperator.minBy(comparator).apply(a,b);
    }
}
