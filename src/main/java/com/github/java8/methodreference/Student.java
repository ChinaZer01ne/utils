package com.github.java8.methodreference;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/8 15:36
 */
public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public Student(){}

    public static int compareStudent(Student student1, Student student2){
        return student1.getScore() - student2.getScore();
    }

    public int compareStudent2(Student student1){
        return student1.getScore() - this.getScore();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }


}
