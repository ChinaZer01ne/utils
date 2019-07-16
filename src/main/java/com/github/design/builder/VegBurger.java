package com.github.design.builder;

/**
 *
 * 创建扩展了 Burger 的实体类。
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 13:40
 */
public class VegBurger extends Burger  {

    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
