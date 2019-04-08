package com.github.java8.methodreference;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/8 16:17
 */
public class StudentComparator {

    public int compareStudentByScore(Student student1,Student student2){
        return student1.getScore() - student2.getScore();
    }

    public int compareStudentByName(Student student1,Student student2){

        return student1.getName().compareTo(student2.getName());
    }
}
