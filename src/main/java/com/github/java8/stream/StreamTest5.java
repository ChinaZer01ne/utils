package com.github.java8.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/12 12:09
 */
public class StreamTest5 {

    public static void main(String[] args) {

        Student student1 = new Student("peach",80);
        Student student2 = new Student("lion",90);
        Student student3 = new Student("apple",100);

        List<Student> students = Arrays.asList(student1, student2, student3);

        System.out.println("=======================");

        System.out.println(students.stream().collect(Collectors.counting()));
        System.out.println((Long) students.stream().count());

        System.out.println(students.stream().collect(minBy(Comparator.comparingInt(Student::getScore))));
        System.out.println(students.stream().collect(maxBy(Comparator.comparingInt(Student::getScore))));
        System.out.println(students.stream().collect(averagingDouble(Student::getScore)));
        System.out.println(students.stream().collect(summingInt(Student::getScore)));
        IntSummaryStatistics collect = students.stream().collect(summarizingInt(Student::getScore));
        System.out.println(students.stream().map(Student::getUsername).collect(Collectors.joining(",")));

        System.out.println("======================");
        Map<Integer, Map<String, List<Student>>> collect1 = students.stream().collect(groupingBy(Student::getScore, groupingBy(Student::getUsername)));
        System.out.println(collect1);

        System.out.println("======================");

        Map<Boolean, List<Student>> collect2 = students.stream().collect(partitioningBy(student -> student.getScore() > 80));
        System.out.println(collect2);

        Map<Boolean, Map<Boolean, List<Student>>> collect3 = students.stream().collect(partitioningBy(student -> student.getScore() > 80, partitioningBy(student -> student.getScore() > 90)));
        System.out.println(collect3);

        System.out.println(students.stream().filter(student -> student.getScore() > 80).collect(Collectors.summingDouble(Student::getScore)));

        //Collector.of(HashMap::new, (theMap, map) -> {
        //    theMap.put("count", 1d);
        //    theMap.put("score", 1d);
        //    return map;
        //    return;
        //}, e -> {
        //    return e;
        //});

        System.out.println(students.stream().collect(groupingBy(Student::getUsername, collectingAndThen(minBy(Comparator.comparingInt(Student::getScore)), Optional::get))));


    }
}
