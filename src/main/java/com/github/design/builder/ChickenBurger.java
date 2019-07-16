package com.github.design.builder;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 13:41
 */
public class ChickenBurger extends Burger  {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}
