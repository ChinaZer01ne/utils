package com.github.design.prototype;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 13:57
 */
public class Dog extends Animal {

    public Dog(){
        type = "Dog";
    }

    @Override
    void say() {
        System.out.println("汪汪汪~");
    }
}
