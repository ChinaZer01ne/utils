package com.github.basic;


import com.github.java8.stream.Student;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/8/14 16:49
 */
public class ValueOrRefrence {

    public static void main(String[] args) {
        Student student = new Student("dog",10);
        testObject(student);
        System.out.println(student);

        Integer value = 1;
        testValue(value);
        System.out.println(value);
    }


    public static void testValue(Integer value){
        value = 10;
    }

    public static void testObject(Student student){

        student = new Student("cat",20);
    }

}
