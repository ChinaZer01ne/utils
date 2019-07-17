package com.github.design.decorator;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/17 13:34
 */
public class ShapeDecorator implements Shape {

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }
    @Override
    public void draw(){
        decoratedShape.draw();
    }
}
