package com.github.java8.methodreference;

import java.util.Arrays;
import java.util.List;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/8 15:16
 */
public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","hello world");

        //list.forEach(str -> System.out.println(str));

        list.forEach(System.out::println);

        System.out.println("====================");

        Student student1 = new Student("a",20);
        Student student2 = new Student("b",10);
        Student student3 = new Student("c",40);
        Student student4 = new Student("d",30);

        List<Student> students = Arrays.asList(student1,student2,student3,student4);

        students.sort((stu1,stu2) -> Student.compareStudent(stu1,stu2));
        students.forEach(s -> System.out.println(s.getScore()));

        System.out.println("===========================");

        students.sort(Student::compareStudent);
        students.forEach(s -> System.out.println(s.getScore()));

        System.out.println("===========================");

        StudentComparator comparator = new StudentComparator();
        students.sort(comparator::compareStudentByScore);
        students.forEach(s -> System.out.println(s.getScore()));

        System.out.println("===========================");

        students.sort(comparator::compareStudentByName);
        students.forEach(s -> System.out.println(s.getScore()));

        System.out.println("===========================");


    }
}
