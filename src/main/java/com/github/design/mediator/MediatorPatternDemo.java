package com.github.design.mediator;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 15:06
 */
public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
