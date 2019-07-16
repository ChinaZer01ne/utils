package com.github.design.prototype;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 14:00
 */
public class Cat extends Animal {
    public Cat(){
        type = "Cat";
    }

    @Override
    void say() {
        System.out.println("喵喵喵~");
    }
}
