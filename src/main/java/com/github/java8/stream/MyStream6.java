package com.github.java8.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MyStream6 {
    public static void main(String[] args) {
        Student student1 = new Student("peach",80);
        Student student2 = new Student("lion",95);
        Student student3 = new Student("apple",100);

        List<Student> students = Arrays.asList(student1, student2, student3);

        System.err.println("=====================");
        //int count = 0;
        //double score = 0;
        System.err.println("custom : " + students.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 80,
                Collector.of(HashMap<String,Double>::new,(theMap, student) ->{

                    System.err.println(student.getScore() + "theMap" + theMap.hashCode() + theMap.get("count"));
                    //if (theMap.get("score") == null){
                    //    theMap.put("score",0d);
                    //}
                    theMap.putIfAbsent("score", 0d);
                    //if (theMap.get("count") == null){
                    //    theMap.put("count",0d);
                    //}
                    theMap.putIfAbsent("count", 0d);
                    theMap.put("count", theMap.get("count") + 1);
                    theMap.put("score",theMap.get("score") + student.getScore());
                    System.out.println(theMap);
                }, (theMap,map) -> {
                    System.err.println(theMap );
                    theMap.put("count",theMap.get("count") + map.get("count"));
                    theMap.put("score",theMap.get("score") + map.get("score"));
                    return theMap;
                })
        )));
        System.err.println("=====================");
    }
}
