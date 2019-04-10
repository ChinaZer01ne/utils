package com.github.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/10 16:45
 */
public class MyStream2 {
    public static void main(String[] args) {

        Stream<String> stream = Stream.of("hello","world","peach");

        //
        //String[] strs = stream.toArray(String[]::new);
        //
        //Arrays.asList(strs).forEach(System.out::println);
        List<String> stringList = stream.collect(() -> {
            ArrayList<String> list = new ArrayList<>();
            System.out.println("supplier " + list);
            return list;
        }, (theList,ele) -> {
            theList.add(ele);
            System.out.println("travel " + theList);
        }, (theList1,theList2) ->{
            System.out.println("merge thisList1 " + theList1);
            System.out.println("merge thisList1 " +theList2);
            theList1.addAll(theList2);
        });
        //List<String> stringList = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(stringList);
    }
}
