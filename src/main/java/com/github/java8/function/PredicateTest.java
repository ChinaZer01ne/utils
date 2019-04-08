package com.github.java8.function;

import java.util.function.Predicate;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/8 12:00
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate = p -> {
          return p.length() > 5;
        };

        System.out.println(predicate.test("hello world"));
    }
}
