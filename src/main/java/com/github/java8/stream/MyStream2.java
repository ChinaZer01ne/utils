package com.github.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 关于stream.parallel().collect()和stream.collect()的区别
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/10 16:45
 */
public class MyStream2 {
    public static void main(String[] args) {
        serilize();
        parallel();

    }

    private static void serilize(){
        Stream<String> stream = Stream.of("hello","world","peach");

        List<String> stringList = stream.collect(() -> {
            ArrayList<String> list = new ArrayList<>();
            System.out.println("supplier " + list);
            return list;
        }, (theList,ele) -> {
            theList.add(ele);
            System.out.println("travel " + theList);
        }, (theList1,theList2) ->{
            //在串行的情况下，并不会输出这一段
            System.out.println("merge thisList1 " + theList1);
            System.out.println("merge thisList2 " +theList2);
            theList1.addAll(theList2);
            System.out.println("merge thisList1 addAll " + theList1);
        });
        //List<String> stringList = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(stringList);

        //stream.collect(Collectors.toCollection(TreeSet::new));

        //Stream<String> stringStream = Stream.of("hello","world","peach");
        //String concat = stringStream.collect(StringBuilder::new, StringBuilder::append,(s1,s2)->{}).toString();
        //System.out.println(concat);
    }

    private static void parallel(){
        Stream<String> stream = Stream.of("hello","world","peach");

        //在并行情况下，会使用多个list进行add操作，最后再把这些list进行merge
        List<String> stringList = stream.parallel().collect(() -> {
            ArrayList<String> list = new ArrayList<>();
            System.out.println("supplier " + list);
            return list;
        }, (theList,ele) -> {
            theList.add(ele);
            System.out.println("travel " + theList);
        }, (theList1,theList2) ->{

            System.out.println("merge thisList1 " + theList1);
            System.out.println("merge thisList2 " +theList2);
            theList1.addAll(theList2);
            System.out.println("merge thisList1 addAll " + theList1);
        });
        //List<String> stringList = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(stringList);

    }
}
