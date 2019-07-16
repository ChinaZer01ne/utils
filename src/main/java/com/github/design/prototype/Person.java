package com.github.design.prototype;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 14:01
 */
public class Person extends Animal {
    public Person(){
        type = "Person";
    }

    @Override
    void say() {
        System.out.println("What's your problem?");
    }
}
