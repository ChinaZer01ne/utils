package com.github.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/11 16:50
 */
public class StreamTest3 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello world","hello welcome","world hello");

        list.stream().flatMap(str -> Arrays.asList(str.split(" ")).stream()).distinct().forEach(System.out::println);
        //list.stream().map(str -> str.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
    }
}
