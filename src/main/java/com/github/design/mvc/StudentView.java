package com.github.design.mvc;

/**
 * 创建视图。
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/17 14:16
 */
public class StudentView {

    public void printStudentDetails(String studentName, String studentRollNo){
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}
