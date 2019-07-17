package com.github.design.facade;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/17 13:48
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
