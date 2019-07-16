package com.github.design.abstarct_factory.animal;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 11:23
 */
public class Cat implements Animal {
    @Override
    public void say() {
        System.out.println("cat: 喵喵喵~");
    }
}
