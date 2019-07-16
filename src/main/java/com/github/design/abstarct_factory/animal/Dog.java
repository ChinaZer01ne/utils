package com.github.design.abstarct_factory.animal;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 11:22
 */
public class Dog implements Animal {
    @Override
    public void say() {
        System.out.println("dog: 汪汪汪~");
    }
}
