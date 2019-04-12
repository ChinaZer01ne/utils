package com.github.java8.stream;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/12 11:39
 */
public class Student {
    private String username;
    private int score;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(String username,  int score) {
        this.username = username;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", score=" + score +
                '}';
    }
}
