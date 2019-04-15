package com.github.java8.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyStream7 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("peach","world","hello","welcome","lion");

        //list.sort(String::compareTo);
        //System.out.println(list);
        //
        //Collections.sort(list,(o1,o2) -> o1.length() - o2.length());
        //System.out.println(list);
        //
        //Collections.sort(list,(o1,o2) -> o2.length() - o1.length());
        //System.out.println(list);
        ////降序
        //Collections.sort(list, Comparator.comparingInt(String::length).reversed());
        //System.out.println(list);
        //
        //Collections.sort(list, Comparator.comparingInt((String item) -> item.length()).reversed());
        //Collections.sort(list, Comparator.comparingInt(item -> item.length()));

        //Collections.sort(list,Comparator.comparingInt(String::length));
        //System.out.println(list);
        //Collections.sort(list,Comparator.comparingInt(String::length).thenComparing(String::compareTo));
        //System.out.println(list);
        //Collections.sort(list,Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));
        //Collections.sort(list,Comparator.comparingInt(String::length).thenComparing(Comparator.comparing(String::toLowerCase)));
        Collections.sort(list,Comparator.comparingInt(String::length).thenComparing(Comparator.comparing(String::toLowerCase,Comparator.reverseOrder())));
        System.out.println(list);

    }
}
