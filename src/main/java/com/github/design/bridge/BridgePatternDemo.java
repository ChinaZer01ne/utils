package com.github.design.bridge;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/17 11:00
 */
public class BridgePatternDemo {

    public static void main(String[] args) {
        Shape redCircle = new Circle(100,100, 10, new RedCircle());
        Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
