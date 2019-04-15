package com.github.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/15 11:10
 */
public class MyStream8 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("peach","world","hello","welcome","lion");
        list.stream().collect(new MySetCollector());
        System.out.println(list);
    }
}
