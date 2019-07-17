package com.github.design.decorator;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/17 13:33
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
