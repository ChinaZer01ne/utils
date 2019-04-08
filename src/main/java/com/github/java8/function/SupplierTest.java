package com.github.java8.function;

import java.util.function.Supplier;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/8 13:52
 */
public class SupplierTest {
    public static void main(String[] args) {
        Supplier supplier = () -> "hello world";

        System.out.println(supplier.get());


        Supplier<Student> studentSupplier = () -> new Student();

        Student student = studentSupplier.get();
        System.out.println(student.getUsername());
        System.out.println("==============");

        Supplier<Student> studentSupplier2 = Student::new;
        Student student2 = studentSupplier2.get();
        System.out.println(student2.getUsername());

    }
}
