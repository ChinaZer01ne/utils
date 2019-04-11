package com.github.java8.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/11 9:47
 */
public class StreamTest2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world2", "peach");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        //源没有改变
        System.out.println(list);

        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1,2),Arrays.asList(3,5),Arrays.asList(7,9));

        stream.flatMap(Collection::stream).map(x -> x * x).forEach(System.out::println);

        Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).min().ifPresent(System.out::println);
        IntSummaryStatistics intSummaryStatistics = Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).summaryStatistics();
        System.out.println(intSummaryStatistics.getAverage());


        list.stream().mapToInt(ele -> {
            int length = ele.length();
            System.err.println(ele);
            return length;
        }).filter(ele -> ele == 5).findFirst().ifPresent(System.out::println);
    }
}
