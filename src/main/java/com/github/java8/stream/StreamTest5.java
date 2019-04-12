package com.github.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    }
}
