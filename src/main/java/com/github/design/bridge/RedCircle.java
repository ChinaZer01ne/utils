package com.github.design.bridge;

/**
 *
 * 创建实现了 DrawAPI 接口的实体桥接实现类。
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/17 10:50
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius +", x: " +x+", "+ y +"]");
    }
}
