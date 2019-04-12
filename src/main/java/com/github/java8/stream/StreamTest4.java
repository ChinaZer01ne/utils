package com.github.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分组和分区
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/12 11:38
 */
public class StreamTest4 {
    public static void main(String[] args) {
        Student student1 = new Student("peach",80);
        Student student2 = new Student("lion",90);
        Student student3 = new Student("apple",100);

        List<Student> students = Arrays.asList(student1, student2, student3);

        Map<String, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getUsername));
        System.out.println(collect);
        //按分数分组
        Map<Integer, List<Student>> collect1 = students.stream().collect(Collectors.groupingBy(Student::getScore));
        System.out.println(collect1);
        //select name,count(*) from student group by name;
        Map<String, Long> collect2 = students.stream().collect(Collectors.groupingBy(Student::getUsername, Collectors.counting()));
        System.out.println(collect2);
        Map<String, Double> collect3 = students.stream().collect(Collectors.groupingBy(Student::getUsername, Collectors.averagingDouble(Student::getScore)));
        System.out.println(collect3);
    }
}
