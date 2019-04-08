package com.github.java8.function;

import java.util.Optional;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/8 14:32
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello");

        //不推荐使用
        if (optional.isPresent()){
            System.out.println(optional.get());
        }

        //推荐使用
        optional.ifPresent(str -> System.out.println(str));

        System.out.println("=============================");
        //如果optional里面没有值，则取另一个值
        System.out.println(optional.orElse("world"));

        System.out.println("=============================");

        System.out.println(optional.orElseGet(() -> "nihao"));
    }
}
