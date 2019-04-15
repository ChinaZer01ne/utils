package com.github.java8.stream;

import java.util.*;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/15 11:45
 */
public class MyStream9 {
    public static void main(String[] args) {

        for (int i = 0; i < 1; i++) {
            List<String> list = Arrays.asList("peach","world","hello","welcome","lion");
            Set<String> set = new HashSet<>();
            set.addAll(list);

            System.out.println(set.parallelStream().collect(new MySetCollector2<>()));
        }

    }
}
