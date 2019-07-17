package com.github.design.facade;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/17 13:46
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}
