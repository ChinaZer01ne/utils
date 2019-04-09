package com.github.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/9 15:38
 */
public class StreamTest1 {
    public static void main(String[] args) {
        IntStream.of(new int[]{1,2,3}).forEach(System.out::println);
        System.out.println("===================");
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println(list.stream().map(ele -> ele * 2).reduce(0, Integer::sum));
    }
}
