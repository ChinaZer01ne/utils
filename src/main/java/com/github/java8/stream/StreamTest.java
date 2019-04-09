package com.github.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/9 15:28
 */
public class StreamTest {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello","world");

        String[] array = new String[]{};
        Stream<String> stream1 = Stream.of(array);
        Stream<String> stream2 = Arrays.stream(array);

        List<String> list = Arrays.asList(array);
        Stream<String> stream3 = list.stream();
    }
}
