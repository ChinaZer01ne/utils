package com.github.java8.function;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/8 10:22
 */
public class FunctionTest2 {
    public static void main(String[] args) {
        FunctionTest2 functionTest2 = new FunctionTest2();

        System.out.println(functionTest2.compute1(2,value -> value * 3,value -> value * value));
        System.out.println(functionTest2.compute2(2,value -> value * 3,value -> value * value));

        //biFunction
        System.out.println(functionTest2.compute3(1,2,(first,second)-> first + second));
        System.out.println(functionTest2.compute3(1,2,(first,second)-> first * second));

        System.out.println(functionTest2.compute4(1,2,(first,second)-> first * second, value -> value * value));
    }

    public int compute1(int a, Function<Integer,Integer> function1, Function<Integer,Integer> function2){
        return function1.compose(function2).apply(a);
    }
    public int compute2(int a, Function<Integer,Integer> function1, Function<Integer,Integer> function2){
        return function1.andThen(function2).apply(a);
    }

    public int compute3(int a, int b, BiFunction<Integer,Integer,Integer> biFunction) {
        return biFunction.apply(a,b);
    }

    public int compute4(int a, int b, BiFunction<Integer,Integer,Integer> biFunction,Function<Integer,Integer> function) {
        return biFunction.andThen(function).apply(a,b);
    }
}
