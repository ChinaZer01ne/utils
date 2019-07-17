package com.github.design.bridge;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/17 10:51
 */
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius +", x: " +x+", "+ y +"]");
    }
}
