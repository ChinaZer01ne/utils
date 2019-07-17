package com.github.design.facade;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/17 13:47
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}
