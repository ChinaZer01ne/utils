package com.github.design.bridge;

/**
 *
 * 使用 DrawAPI 接口创建抽象类 Shape。
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/17 10:53
 */
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
